

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;





public class GUI extends BorderPane {

    private Button dashboard;
    private Button users;
    private Button loans;
    private Button payments;
    private Button reports;
    private Button settings;
    private Button logout;

    private TextField idTextField = new TextField();
    private TextField nameTextField = new TextField();
    private TextField surnameTextField = new TextField();
    private ComboBox<String> genderComboBox = new ComboBox<>();
    private TextField procedureTextField = new TextField();
    private TextField diagnosisTextField = new TextField();
    
    public GUI() {
        setup();
        dashboard.setOnAction(e -> {
        
        		

            // Add pie chart
            PieChart pieChart = createPieChart();
            
            
            
            
            
            
         // Create cards
            GridPane cardsPane = new GridPane();
            cardsPane.setHgap(20);
            cardsPane.setVgap(20);
            cardsPane.setPadding(new Insets(60,60,60,60));

         
            String lightBlue = "linear-gradient(to right,#61D8DE, #E839F6)";
            String lightGreen = "linear-gradient(to right, green, yellow)";
            String lightCoral = "linear-gradient(to right, darkorange,yellow)";
            String lightSalmon = "linear-gradient(red,blue)";
            
            
            
            GridPane card1 = createCard("New Loans", "40", "nw.png", lightBlue);
            cardsPane.add(card1, 0, 0);

            GridPane card2 = createCard("Interest", "40%", "int2.png", lightGreen);
            cardsPane.add(card2, 1, 0);

            GridPane card3 = createCard("Oustanding", "70", "D.png", lightCoral);
            cardsPane.add(card3, 2, 0);

            GridPane card4 = createCard("User Registarion", "400", "all.png", lightSalmon);
            cardsPane.add(card4, 3, 0);

            
           
            // Create HBox to hold PieChart and BarChart
            HBox chartBox = new HBox();
            chartBox.getChildren().addAll(createPieChart(), createBarChart());

           // Create VBox to hold PieChart, BarChart, and cards
           VBox contentBox = new VBox();
           contentBox.getChildren().addAll(cardsPane,chartBox);

            // Add contentBox to the center of the layout
            setCenter(contentBox);
        		
        		
        });
        
        
        loans.setOnAction(e -> {
        	
        	showDashboard();
        });
    }

    private void setup() {
        // Header
        HBox header = new HBox();
        header.setSpacing(30);
        header.setPadding(new Insets(10, 10, 10, 10));
        header.getStyleClass().add("header");
        Label titleLabel = new Label("Loan Admin Dashboard");
        titleLabel.getStyleClass().add("title");
        header.getChildren().add(titleLabel);
        setTop(header);

        // Sidebar
        VBox sidebar = new VBox();
        sidebar.setSpacing(10);
        sidebar.setPadding(new Insets(10, 10, 10, 10));
        sidebar.getStyleClass().add("sidebar");
        sidebar.setStyle("-fx-background-color: #333333;");

        Image adminImage = new Image("Admin.png");
        ImageView adminImageView = new ImageView(adminImage);
        adminImageView.setFitWidth(200);
        adminImageView.setFitHeight(200);
        sidebar.getChildren().add(adminImageView);

        // Buttons
        dashboard = createSidebarButton("Dashboard", "h.jpg");
        users = createSidebarButton("User Registration", "all.png");
        loans = createSidebarButton("Loans", "p.jpg");
        payments = createSidebarButton("Payments", "pay.png");
        reports = createSidebarButton("Reports", "Reports.jpg");
        settings = createSidebarButton("Settings", "settings.jpg");
        logout = createSidebarButton("Logout", "out.jpg");

        // Add buttons to sidebar
        sidebar.getChildren().addAll(dashboard, users, loans, payments, reports, settings, logout);
        setLeft(sidebar);

        // Initialize gender combo box
        genderComboBox.getItems().addAll("Male", "Female", "Other");

        // Dashboard content area
        HBox dashboardContent = new HBox();
        dashboardContent.setSpacing(20);
        dashboardContent.setPadding(new Insets(20));
        dashboardContent.setAlignment(Pos.CENTER);
        setCenter(dashboardContent);

      
        // Add pie chart
        PieChart pieChart = createPieChart();
        
        
        
        
        
        
     // Create cards
        GridPane cardsPane = new GridPane();
        cardsPane.setHgap(20);
        cardsPane.setVgap(20);
        cardsPane.setPadding(new Insets(60,60,60,60));

     
        String lightBlue = "linear-gradient(to right,#61D8DE, #E839F6)";
        String lightGreen = "linear-gradient(to right, green, yellow)";
        String lightCoral = "linear-gradient(to right, darkorange,yellow)";
        String lightSalmon = "linear-gradient(red,blue)";
        
        
        
        
        GridPane card1 = createCard("New Loans", "40", "nw.png", lightBlue);
        cardsPane.add(card1, 1, 0);

        GridPane card2 = createCard("Interest", "40%", "int2.png", lightGreen);
        cardsPane.add(card2, 2, 0);

        GridPane card3 = createCard("Oustanding", "70", "D.png", lightCoral);
        cardsPane.add(card3, 3, 0);

        GridPane card4 = createCard("User Registarion", "400", "all.png", lightSalmon);
        cardsPane.add(card4, 4, 0);

        
        
        // Create HBox to hold PieChart and BarChart
           HBox chartBox = new HBox();
           chartBox.getChildren().addAll(createPieChart(), createBarChart());

        // Create VBox to hold PieChart, BarChart, and cards
        VBox contentBox = new VBox();
        contentBox.getChildren().addAll(cardsPane,chartBox);

        // Add contentBox to the center of the layout
        setCenter(contentBox);
       
        
        
        
    }

    private Button createSidebarButton(String text, String imageUrl) {
        Image image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(24);
        imageView.setFitHeight(24);
        Button button = new Button(text, imageView);
        button.getStyleClass().add("viewStatisticsButton");
        return button;
    }

    
    
    
    
  
    
    
    
    
    
    
    
    private PieChart createPieChart() {
        PieChart pieChart = new PieChart();
        pieChart.setTitle("Pro.net");
       
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Loans", 30),
            new PieChart.Data("Interest", 20),
            new PieChart.Data("Payment", 50)
        );
        pieChart.setData(pieChartData);
        return pieChart;
    }

    private void showDashboard() {
        // Clear the center of the BorderPane
        setCenter(null);

        // Create a VBox to hold the content
        VBox dashboardContent = new VBox();
        dashboardContent.setAlignment(Pos.CENTER);
        dashboardContent.setSpacing(20);
        dashboardContent.setPadding(new Insets(20));

        // Add some labels to the VBox as an example content
        Label titleLabel = new Label("Dashboard Content");
        titleLabel.getStyleClass().add("dashboard-title");

        Label infoLabel = new Label("Welcome to the Dashboard!");
        infoLabel.getStyleClass().add("dashboard-info");

        dashboardContent.getChildren().addAll(titleLabel, infoLabel);

        // Set the VBox as the center of the BorderPane
        setCenter(dashboardContent);
    }
    
    
    private GridPane createCard(String title, String description, String imageUrl, String backgroundColor) {
        GridPane card = new GridPane();
        card.setPadding(new Insets(10));
        card.setPrefSize(200, 150);
        card.setStyle("-fx-background-color: " + backgroundColor + "; -fx-border-color: #ccc; -fx-border-width: 1px;");

        // Title
        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-weight: bold;");

        // Description
        Label descriptionLabel = new Label(description);
        descriptionLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;"); 

        // Image
        Image image = new Image(imageUrl);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(30);
        imageView.setFitHeight(60);
      

        // Add components to the card
        card.add(titleLabel, 1, 0);
        card.add(descriptionLabel, 0, 7);
        card.add(imageView, 3, 4, 1, 2);

        return card;
    }
    
    private BarChart<String, Number> createBarChart() {
        // Define axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        yAxis.setPrefWidth(20);
        
        
        
        // Create BarChart
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Monthly Interest");

        // Add data to the bar chart (replace this with your actual data)
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("April", 10));
        series.getData().add(new XYChart.Data<>("May", 20));
        series.getData().add(new XYChart.Data<>("June", 30));

        // Add series to the bar chart
        barChart.getData().add(series);

        return barChart;
    }
    
} 
