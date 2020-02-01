package com.codename1.demos.kitchen.componentdemos;

import com.codename1.demos.kitchen.charts.LineChartDemo;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.Container;

import static com.codename1.demos.kitchen.charts.ChartDemosList.getBarChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getBubbleChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getCombinedXYChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getCubicLineChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getDialChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getDonutChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getPieChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getRadarChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getRoundChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getSampleChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getScatterChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getTimeChartButton;

class ChartsDemo extends DemoComponent {
    private static Container chartsContainer() {
        ComponentDemo demo = new ComponentDemo("Charts");
        demo.add("Bar Chart", getBarChartButton());
        demo.add("Bubble Chart", getBubbleChartButton());
        demo.add("CombinedXY Chart", getCombinedXYChartButton());
        demo.add("CubicLine Chart", getCubicLineChartButton());
        demo.add("Dial Chart", getDialChartButton());
        demo.add("Donut Chart", getDonutChartButton());
        demo.add("Line Chart", getSampleChartButton("Line Chart", new LineChartDemo()));
        demo.add("Pie Chart", getPieChartButton());
        demo.add("Radar Chart", getRadarChartButton());
        demo.add("Round Chart", getRoundChartButton());
        demo.add("Scatter Chart", getScatterChartButton());
        demo.add("Time Chart", getTimeChartButton());
        return demo.generate();
    }

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

    ;
}
