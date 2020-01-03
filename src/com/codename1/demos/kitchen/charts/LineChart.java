/**
 * Copyright (C) 2009 - 2013 SC 4ViewSoft SRL
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.codename1.demos.kitchen.charts;

import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.CubicLineChart;
import com.codename1.charts.views.PointStyle;
import com.codename1.ui.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Multiple temperature demo chart.
 */
public class LineChart extends AbstractDemoChart {
    private XYMultipleSeriesDataset dataSet;

    public String getName() {
        return "Temperature and sunshine";
    }

    public String getDesc() {
        return "The average temperature and hours of sunshine in Crete (line chart with multiple Y scales and axis)";
    }

    private XYMultipleSeriesDataset getTempData() {
        if (dataSet == null) {
            String[] titles = new String[]{"Air temperature"};
            List<double[]> x = Arrays.asList(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
            List<double[]> values = Arrays.asList(new double[]{12.3, 12.5, 13.8, 16.8, 20.4, 24.4, 26.4, 26.1, 23.6, 20.3, 17.2,
                    13.9});
            dataSet = buildDataset(titles, x, values);
        }
        return dataSet;
    }

    public Component execute() {
        int[] colors = new int[]{ColorUtil.BLUE};
        PointStyle[] styles = new PointStyle[]{PointStyle.CIRCLE};
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer(1);
        renderer.setYTitle("Avg Temperature", 0);
        renderer.setXTitle("Month");
        setRenderer(renderer, colors, styles);
        initRendererer(renderer);
        CubicLineChart chart = new CubicLineChart(getTempData(), renderer, 0.2f);
        return newChart(chart);
    }
}
