/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness.tracker.util;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author rhars
 */
public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
    }

    private void init(Stage primaryStage) {
        HBox root = new HBox();
        Scene scene = new Scene(root, 500, 500);
        
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Day");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Calories burnt");
        
        LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
        lineChart.setTitle("Calories");
        
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        data.getData().add(new XYChart.Data<String, Number>("Mon", 420));
        data.getData().add(new XYChart.Data<String, Number>("Tue", 520));
        data.getData().add(new XYChart.Data<String, Number>("Wed", 620));
        data.getData().add(new XYChart.Data<String, Number>("Thu", 360));
        data.getData().add(new XYChart.Data<String, Number>("Fri", 260));
        data.getData().add(new XYChart.Data<String, Number>("Sat", 100));
        data.getData().add(new XYChart.Data<String, Number>("Sun", 50));
        
        lineChart.getData().add(data);
        root.getChildren().add(lineChart);
        
        primaryStage.setTitle("Graph Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
