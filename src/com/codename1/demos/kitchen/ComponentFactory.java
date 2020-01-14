package com.codename1.demos.kitchen;

import com.codename1.demos.kitchen.components.ComponentDemo;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;

import static com.codename1.demos.kitchen.charts.ChartDemosList.getBarChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getBubbleChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getCombinedXYChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getCubicLineChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getDialChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getDonutChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getLineChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getPieChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getRadarChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getRoundChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getScatterChartButton;
import static com.codename1.demos.kitchen.charts.ChartDemosList.getTimeChartButton;
import static com.codename1.ui.CN.CENTER;

class ComponentFactory {
    static Component chartsContainer() {
        ComponentDemo demo = new ComponentDemo("Charts");
        demo.add("Bar Chart", getBarChartButton());
        demo.add("Bubble Chart", getBubbleChartButton());
        demo.add("CombinedXY Chart", getCombinedXYChartButton());
        demo.add("CubicLine Chart", getCubicLineChartButton());
        demo.add("Dial Chart", getDialChartButton());
        demo.add("Donut Chart", getDonutChartButton());
        demo.add("Line Chart", getLineChartButton());
        demo.add("Pie Chart", getPieChartButton());
        demo.add("Radar Chart", getRadarChartButton());
        demo.add("Round Chart", getRoundChartButton());
        demo.add("Scatter Chart", getScatterChartButton());
        demo.add("Time Chart", getTimeChartButton());
        return  demo.generate(true);
    }

}
