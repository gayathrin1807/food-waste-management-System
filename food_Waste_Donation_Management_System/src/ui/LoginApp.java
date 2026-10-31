
package ui;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import model.User;
import service.UserService;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class LoginApp {

    private static final AtomicBoolean started = new AtomicBoolean(false);

    public static class LoginResult {
        private User user;
        private boolean admin;
        private boolean cancelled;

        public LoginResult(User user, boolean admin, boolean cancelled) {
            this.user = user;
            this.admin = admin;
            this.cancelled = cancelled;
        }

        public User getUser() {
            return user;
        }

        public boolean isAdmin() {
            return admin;
        }

        public boolean isCancelled() {
            return cancelled;
        }
    }

    public static LoginResult showLogin(UserService userService) {

        CountDownLatch latch = new CountDownLatch(1);
        AtomicReference<LoginResult> result =
                new AtomicReference<>(new LoginResult(null, false, true));

        Runnable showWindow = () -> {

            Stage stage = new Stage();

            Label heading = new Label("Welcome Back!");
            heading.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            heading.setTextFill(Color.web("#163B70"));

            Label subtitle = new Label(
                    "Food Waste Donation Management System");
            subtitle.setTextFill(Color.web("#64748B"));

            Label roleLabel = new Label("Login As");

            ComboBox<String> roleBox = new ComboBox<>();
            roleBox.getItems().addAll("Donor", "NGO / Volunteer", "Admin");
            roleBox.setValue("Donor");
            roleBox.setMaxWidth(Double.MAX_VALUE);

            Label emailLabel = new Label("Email / Username");

            TextField emailField = new TextField();
            emailField.setPromptText("Enter your email or username");

            Label passwordLabel = new Label("Password");

            PasswordField passwordField = new PasswordField();
            passwordField.setPromptText("Enter your password");

            Label message = new Label();
            message.setTextFill(Color.RED);

            Button loginButton = new Button("LOGIN");
            loginButton.setMaxWidth(Double.MAX_VALUE);
            loginButton.setPrefHeight(42);

            loginButton.setStyle(
                "-fx-background-color: #1769AA;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 8;"
            );

            loginButton.setOnAction(e -> {

                String username = emailField.getText().trim();
                String password = passwordField.getText();
                String role = roleBox.getValue();

                if (username.isEmpty() || password.isEmpty()) {
                    message.setText("Please enter your login details.");
                    return;
                }

                if (role.equals("Admin")) {

                    if (username.equals("admin")
                            && password.equals("admin123")) {

                        result.set(new LoginResult(null, true, false));
                        stage.close();

                    } else {
                        message.setText("Invalid admin username or password!");
                    }

                } else {

                    User user = userService.loginUser(username, password);

                    String expectedRole =
                            role.equals("Donor") ? "DONOR" : "NGO";

                    if (user != null &&
                            user.getRole().equalsIgnoreCase(expectedRole)) {

                        result.set(new LoginResult(user, false, false));
                        stage.close();

                    } else {
                        message.setText("Invalid email or password!");
                    }
                }
            });

            VBox form = new VBox(12,
                    heading, subtitle,
                    roleLabel, roleBox,
                    emailLabel, emailField,
                    passwordLabel, passwordField,
                    message, loginButton
            );

            form.setAlignment(Pos.CENTER_LEFT);
            form.setPadding(new Insets(35));
            form.setMaxWidth(430);

            form.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 15;"
            );

            StackPane root = new StackPane(form);
            root.setPadding(new Insets(30));
            root.setStyle("-fx-background-color: #EAF3FC;");

            Scene scene = new Scene(root, 650, 550);

            stage.setTitle("Food Waste Donation Management - Login");
            stage.setScene(scene);
            stage.setResizable(false);

            stage.setOnHidden(e -> latch.countDown());

            stage.show();
        };

        try {
            if (started.compareAndSet(false, true)) {
                Platform.startup(() -> {
                    Platform.setImplicitExit(false);
                    showWindow.run();
                });
            } else {
                Platform.runLater(showWindow);
            }

            latch.await();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.get();
    }
}
