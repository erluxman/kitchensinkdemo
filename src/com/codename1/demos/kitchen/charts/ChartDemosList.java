package com.codename1.demos.kitchen.charts;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.CN.CENTER;

public class ChartDemosList {
    public static Button getLineChartButton() {
        Button showLineChart = new Button("Line Chart");
        Form lineChartViewer = new Form("Line Charts ", new BorderLayout());
        lineChartViewer.add(CENTER, BorderLayout.center(new LineChart().execute()));
        lineChartViewer.getToolbar().setBackCommand("Line Chart", ee -> showLineChart.getComponentForm().showBack());
        showLineChart.addActionListener(evt -> {
            lineChartViewer.show();
        });
        return showLineChart;
    }

    public static Button getBarChartButton() {
        Button showBarChart = new Button("Bar Chart");
        Form barChartViewer = new Form("Bar Charts ", new BorderLayout());
        barChartViewer.add(CENTER, BorderLayout.center(new BarChartDemo().execute()));
        barChartViewer.getToolbar().setBackCommand("Bar Chart", ee -> showBarChart.getComponentForm().showBack());
        showBarChart.addActionListener(evt -> {
            barChartViewer.show();
        });

        return showBarChart;
    }

    public static Button getPieChartButton() {
        Button showPieChart = new Button("Pie Chart");
        Form pieChartViewer = new Form("Pie Charts ", new BorderLayout());
        pieChartViewer.add(CENTER, BorderLayout.center(new PieChartDemo().execute()));
        pieChartViewer.getToolbar().setBackCommand("Pie Chart", ee -> showPieChart.getComponentForm().showBack());
        showPieChart.addActionListener(evt -> {
            pieChartViewer.show();
        });

        return showPieChart;
    }

    public static Button getScatterChartButton() {
        Button showScatterChart = new Button("Scatter Chart");
        Form scatterChartViewer = new Form("Scatter Charts ", new BorderLayout());
        scatterChartViewer.add(CENTER, BorderLayout.center(new ScatterChartDemo().execute()));
        scatterChartViewer.getToolbar().setBackCommand("Scatter Chart", ee -> showScatterChart.getComponentForm().showBack());
        showScatterChart.addActionListener(evt -> {
            scatterChartViewer.show();
        });

        return showScatterChart;
    }

    public static Button getDonutChartButton() {
        Button showDonutChart = new Button("Donut Chart");
        Form donutChartViewer = new Form("Scatter Charts ", new BorderLayout());
        donutChartViewer.add(CENTER, BorderLayout.center(new DonutChartDemo().execute()));
        donutChartViewer.getToolbar().setBackCommand("Donut Chart", ee -> showDonutChart.getComponentForm().showBack());
        showDonutChart.addActionListener(evt -> {
            donutChartViewer.show();
        });

        return showDonutChart;
    }
}
