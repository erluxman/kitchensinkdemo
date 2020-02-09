package com.codename1.demos.kitchen.componentdemos;

import com.codename1.demos.kitchen.componentdemos.charts.AbstractDemoChart;
import com.codename1.demos.kitchen.componentdemos.charts.BarChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.BubbleChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.CombinedXYChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.CubicLineChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.DialChartDemo;
import com.codename1.demos.kitchen.componentdemos.charts.DonutChartDemo;
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
    private Container chartsContainer() {
        ComponentDemo demo = new ComponentDemo("Charts");
        demo.add(getSubComp("Bar Chart", new BarChartDemo()));
        demo.add(getSubComp("Bubble Chart", new BubbleChartDemo()));
        demo.add(getSubComp("CombinedXY Chart", new CombinedXYChartDemo()));
        demo.add(getSubComp("CubicLine Chart", new CubicLineChartDemo()));
        demo.add(getSubComp("Dial Chart", new DialChartDemo()));
        demo.add(getSubComp("Donut Chart", new DonutChartDemo()));
        demo.add(getSubComp("LineChart", new LineChartDemo()));
        demo.add(getSubComp("Pie Chart", new PieChartDemo()));
        demo.add(getSubComp("Radar Chart", new RadarChartDemo()));
        demo.add(getSubComp("Round Chart", new RoundChartDemo()));
        demo.add(getSubComp("Scatter Chart", new ScatterChartDemo()));
        demo.add(getSubComp("Time Chart", new TimeChartDemo()));
        return demo.generate();
    }

    SubComponent getSubComp(String title, AbstractDemoChart chart) {
        return new SubComponent(title, getSampleChartButton(title, chart));
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
}
