package com.codename1.demos.kitchen.componentdemos;

import com.codename1.components.InfiniteProgress;
import com.codename1.demos.kitchen.containers.ComponentDemo;
import com.codename1.ui.CommonProgressAnimations;
import com.codename1.ui.Container;
import com.codename1.ui.Slider;

class ProgressDemo extends DemoComponent {

    String infiniteProgressInfo ="Shows a \"Washing Machine\" infinite progress indication animation, to customize the image you can either use the infiniteImage theme constant or the setAnimation method. The image is rotated automatically so don't use an animated image or anything like that as it would fail with the rotation logic.";
    String sliderInfo ="The slider component serves both as a slider widget to allow users to select a value on a scale via touch/arrows and also to indicate progress. The slider defaults to percentage display but can represent any positive set of values.\n" ;
    String circleAnimationInfo ="A CommonProgressAnimations which shows radial coloring to show circular progress, like a Pac-Man";
    String textLoadingAnimation ="A CommonProgressAnimations item used to show the text is loading when we are fetching" +
            "some text data from network/database";

    @Override
    public String getImageName() {
        return "progress.png";
    }

    @Override
    public String getTitle() {
        return "Progress";
    }

    @Override
    Container getContent() {
        return progressContainer();
    }

    private Container progressContainer() {
        ComponentDemo demo = new ComponentDemo("Progress");
        InfiniteProgress infiniteProgress = new InfiniteProgress();

        Slider slider = new Slider();
        slider.setProgress(50);
        slider.setEditable(true);

        demo.add("Infinite Progress", infiniteProgress,infiniteProgressInfo);
        demo.add("Slider", slider,sliderInfo);
        demo.add("Circle Animation", new CommonProgressAnimations.CircleProgress(),circleAnimationInfo,CommonProgressAnimations.class);
        demo.add("Text Loading Animation", new CommonProgressAnimations.LoadingTextAnimation().rows(2).cols(1),textLoadingAnimation,CommonProgressAnimations.class);

        return demo.generate();
    }
}
