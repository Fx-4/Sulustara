package controller;

import javafx.scene.layout.Pane;

public class OpenScene {

    public Pane getPane(String sceneName) {
        // Implement logic to load and return the appropriate Pane based on sceneName
        // Example:
        if ("MenuUtama".equals(sceneName)) {
            return createMenuUtamaPane();
        } else if ("cart".equals(sceneName)) {
            return createCartPane();
        } else if ("profile".equals(sceneName)) {
            return createProfilePane();
        } else {
            // Handle unknown scene names or return a default pane
            return new Pane(); // Example of a default empty Pane
        }
    }

    private Pane createMenuUtamaPane() {
        // Implement logic to create and return the MenuUtama Pane
        // Example:
        Pane menuUtamaPane = new Pane();
        // Add your UI components and layout logic here
        return menuUtamaPane;
    }

    private Pane createCartPane() {
        // Implement logic to create and return the cart Pane
        // Example:
        Pane cartPane = new Pane();
        // Add your UI components and layout logic here
        return cartPane;
    }

    private Pane createProfilePane() {
        // Implement logic to create and return the profile Pane
        // Example:
        Pane profilePane = new Pane();
        // Add your UI components and layout logic here
        return profilePane;
    }
}
