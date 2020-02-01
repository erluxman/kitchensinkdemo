package com.codename1.demos.kitchen.charts;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.CN.CENTER;

public class ChartDemosList {
    public static Button getSampleChartButton(String chartName, AbstractDemoChart chartContent) {
        Button showChart = new Button(chartName);
        showChart.addActionListener(evt -> {
            Form lineChartViewer = new Form(chartName, new BorderLayout());
            lineChartViewer.add(CENTER, BorderLayout.center(chartContent.execute()));
            lineChartViewer.getToolbar().setBackCommand(chartName, ee -> showChart.getComponentForm().showBack());
            lineChartViewer.show();
        });
        return showChart;
    }

    public static Button getLineChartButton() {
        Button showLineChart = new Button("Line Chart");
        showLineChart.addActionListener(evt -> {
            Form lineChartViewer = new Form("Line Charts ", new BorderLayout());
            lineChartViewer.add(CENTER, BorderLayout.center(new LineChartDemo().execute()));
            lineChartViewer.getToolbar().setBackCommand("Line Chart", ee -> showLineChart.getComponentForm().showBack());
            lineChartViewer.show();
        });
        return showLineChart;
    }

    public static Button getCubicLineChartButton() {
        Button showCubicLineChart = new Button("Cubic Line Chart");
        showCubicLineChart.addActionListener(evt -> {
            Form cubicLineChartViewer = new Form("Cubic Line Charts ", new BorderLayout());
            cubicLineChartViewer.add(CENTER, BorderLayout.center(new CubicLineChartDemo().execute()));
            cubicLineChartViewer.getToolbar().setBackCommand("Cubic Line Chart", ee -> showCubicLineChart.getComponentForm().showBack());
            cubicLineChartViewer.show();
        });
        return showCubicLineChart;
    }

    public static Button getDialChartButton() {
        Button showDialChart = new Button("Dial Chart");
        showDialChart.addActionListener(evt -> {
            Form dialChartViewer = new Form("Dial Charts ", new BorderLayout());
            dialChartViewer.add(CENTER, BorderLayout.center(new DialChartDemo().execute()));
            dialChartViewer.getToolbar().setBackCommand("Dial Chart", ee -> showDialChart.getComponentForm().showBack());
            dialChartViewer.show();
        });
        return showDialChart;
    }

    public static Button getBarChartButton() {
        Button showBarChart = new Button("Bar Chart");
        showBarChart.addActionListener(evt -> {
            Form barChartViewer = new Form("Bar Charts ", new BorderLayout());
            barChartViewer.add(CENTER, BorderLayout.center(new BarChartDemo().execute()));
            barChartViewer.getToolbar().setBackCommand("Bar Chart", ee -> showBarChart.getComponentForm().showBack());
            barChartViewer.show();
        });

        return showBarChart;
    }

    public static Button getBubbleChartButton() {
        Button showBubbleChart = new Button("Bubble Chart");
        showBubbleChart.addActionListener(evt -> {
            Form barChartViewer = new Form("Bubble Charts ", new BorderLayout());
            barChartViewer.add(CENTER, BorderLayout.center(new BubbleChartDemo().execute()));
            barChartViewer.getToolbar().setBackCommand("Bubble Chart", ee -> showBubbleChart.getComponentForm().showBack());
            barChartViewer.show();
        });

        return showBubbleChart;
    }

    public static Button getCombinedXYChartButton() {
        Button combinedXYChart = new Button("CombinedXY Chart");
        Form combinedXYChartViewer = new Form("CombinedXY Charts ", new BorderLayout());
        combinedXYChartViewer.add(CENTER, BorderLayout.center(new CombinedXYChartDemo().execute()));
        combinedXYChartViewer.getToolbar().setBackCommand("CombinedXY Chart", ee -> combinedXYChart.getComponentForm().showBack());
        combinedXYChart.addActionListener(evt -> {
            combinedXYChartViewer.show();
        });

        return combinedXYChart;
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

    public static Button getRadarChartButton() {
        Button showRadarChart = new Button("Radar Chart");
        Form radarChartViewer = new Form("Radar Charts ", new BorderLayout());
        radarChartViewer.add(CENTER, BorderLayout.center(new RadarChartDemo().execute()));
        radarChartViewer.getToolbar().setBackCommand("Radar Chart", ee -> showRadarChart.getComponentForm().showBack());
        showRadarChart.addActionListener(evt -> {
            radarChartViewer.show();
        });

        return showRadarChart;
    }

    public static Button getRoundChartButton() {
        Button showRoundChart = new Button("Round Chart");
        Form roundChartViewer = new Form("Round Charts ", new BorderLayout());
        roundChartViewer.add(CENTER, BorderLayout.center(new RoundChartDemo().execute()));
        roundChartViewer.getToolbar().setBackCommand("Round Chart", ee -> showRoundChart.getComponentForm().showBack());
        showRoundChart.addActionListener(evt -> {
            roundChartViewer.show();
        });

        return showRoundChart;
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

    public static Button getTimeChartButton() {
        Button showTimeChart = new Button("Time Chart");
        Form timeChartViewer = new Form("Time Charts ", new BorderLayout());
        timeChartViewer.add(CENTER, BorderLayout.center(new TimeChartDemo().execute()));
        timeChartViewer.getToolbar().setBackCommand("Time Chart", ee -> showTimeChart.getComponentForm().showBack());
        showTimeChart.addActionListener(evt -> {
            timeChartViewer.show();
        });

        return showTimeChart;
    }

    public static Button getDonutChartButton() {
        Button showDonutChart = new Button("Donut Chart");
        Form donutChartViewer = new Form("Donut Charts ", new BorderLayout());
        donutChartViewer.add(CENTER, BorderLayout.center(new DonutChartDemo().execute()));
        donutChartViewer.getToolbar().setBackCommand("Donut Chart", ee -> showDonutChart.getComponentForm().showBack());
        showDonutChart.addActionListener(evt -> {
            donutChartViewer.show();
        });

        return showDonutChart;
    }
}
