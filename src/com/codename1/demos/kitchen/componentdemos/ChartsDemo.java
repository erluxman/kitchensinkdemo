package com.codename1.demos.kitchen.componentdemos;

import com.codename1.charts.views.BarChart;
import com.codename1.charts.views.BubbleChart;
import com.codename1.charts.views.CombinedXYChart;
import com.codename1.charts.views.CubicLineChart;
import com.codename1.charts.views.DialChart;
import com.codename1.charts.views.DoughnutChart;
import com.codename1.charts.views.LineChart;
import com.codename1.charts.views.PieChart;
import com.codename1.charts.views.RadarChart;
import com.codename1.charts.views.RoundChart;
import com.codename1.charts.views.ScatterChart;
import com.codename1.charts.views.TimeChart;
import com.codename1.demos.kitchen.componentdemos.charts.AbstractDemoChart;
import com.codename1.demos.kitchen.componentdemos.charts.BarChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.BubbleChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.CombinedXYChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.CubicLineChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.DialChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.DoughnutChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.LineChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.PieChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.RadarChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.RoundChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.ScatterChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.TimeChartDemo;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.demos.kitchen.containers.SubComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.ui.CN.CENTER;

class ChartsDemo extends DemoComponent {
    String barChartInfo = "The bar chart rendering class.";
    String bubbleChartInfo = "The bubble chart rendering class.";
    String combinedXYChartInfo = "The combined XY chart rendering class.";
    String cubicLineChartInfo = "The interpolated (cubic) line chart rendering class.";
    String dialChartInfo = "The dial chart rendering class.";
    String donutChartInfo = "The doughnut chart rendering class.";
    String lineChartInfo = "The line chart rendering class.";
    String pieChartInfo = "The pie chart rendering class.";
    String radarChartInfo = "The radar chart rendering class.";
    String roundChartInfo = "An abstract class to be extended by round like chart rendering classes.";
    String scatterChartInfo = "The scatter chart rendering class.";
    String timeChartInfo = "The time chart rendering class.";

    @Override
    String getImageName() {
        return "charts.png";
    }

    @Override
    String getTitle() {
        return "Charts";
    }

    @Override
    Container getContent() {
        return chartsContainer();
    }

    private Container chartsContainer() {
        ComponentDemo demo = new ComponentDemo("Charts");
        demo.add(getSubComp("Bar Chart", new BarChartDemo(), barChartInfo, BarChart.class));
        demo.add(getSubComp("Bubble Chart", new BubbleChartDemo(), bubbleChartInfo, BubbleChart.class));
        demo.add(getSubComp("CombinedXY Chart", new CombinedXYChartDemo(), combinedXYChartInfo, CombinedXYChart.class));
        demo.add(getSubComp("CubicLine Chart", new CubicLineChartDemo(), cubicLineChartInfo, CubicLineChart.class));
        demo.add(getSubComp("Dial Chart", new DialChartDemo(), dialChartInfo, DialChart.class));
        demo.add(getSubComp("Donut Chart", new DoughnutChartDemo(), donutChartInfo, DoughnutChart.class));
        demo.add(getSubComp("LineChart", new LineChartDemo(), lineChartInfo, LineChart.class));
        demo.add(getSubComp("Pie Chart", new PieChartDemo(), pieChartInfo, PieChart.class));
        demo.add(getSubComp("Radar Chart", new RadarChartDemo(), radarChartInfo, RadarChart.class));
        demo.add(getSubComp("Round Chart", new RoundChartDemo(), roundChartInfo, RoundChart.class));
        demo.add(getSubComp("Scatter Chart", new ScatterChartDemo(), scatterChartInfo, ScatterChart.class));
        demo.add(getSubComp("Time Chart", new TimeChartDemo(), timeChartInfo, TimeChart.class));
        return demo.generate();
    }

    SubComponent getSubComp(String title, AbstractDemoChart chart, String info, Class javaClass) {
        return new SubComponent(title, getSampleChartButton(title, chart), info, javaClass);
    }

    public Button getSampleChartButton(String chartName, AbstractDemoChart chartContent) {
        Button showChart = new Button(chartName);
        showChart.addActionListener(evt -> {
            Form lineChartViewer = new Form(chartName, new BorderLayout());
            lineChartViewer.add(CENTER, BorderLayout.center(chartContent.execute()));
            lineChartViewer.getToolbar().setBackCommand(chartName, ee -> showChart.getComponentForm().showBack());
            lineChartViewer.show();
        });
        return showChart;
    }
}
