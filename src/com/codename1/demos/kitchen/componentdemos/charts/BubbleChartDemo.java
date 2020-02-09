package com.codename1.demos.kitchen.componentdemos.charts;

import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.models.XYValueSeries;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.BubbleChart;
import com.codename1.ui.Component;

public class BubbleChartDemo extends AbstractDemoChart {
    @Override
    public Component execute() {
        XYMultipleSeriesDataset series = new XYMultipleSeriesDataset();

        XYValueSeries newTicketSeries = new XYValueSeries("Laptop Speed");
        newTicketSeries.add(4f, 4, 32);
        newTicketSeries.add(8f, 2, 32);
        newTicketSeries.add(8f, 3, 48);
        newTicketSeries.add(16f, 4, 128);
        series.addSeries(newTicketSeries);

        XYSeriesRenderer newTicketRenderer = new XYSeriesRenderer();

        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.addSeriesRenderer(newTicketRenderer);
        initRendererer(renderer);

        setChartSettings(renderer, "Laptop Speed", "RAM", "Processor GHz", 0.5, 17.5, 0, 5, ColorUtil.GRAY,
                ColorUtil.LTGRAY);
        return newChart(new BubbleChart(series, renderer));
    }
}
