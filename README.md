# RatioImageView

## 快速使用

```xml
<me.bakumon.library.RatioImageView
    android:layout_width="match_parent"
    android:layout_height="0dp"
    app:dimensionRatio="3:1" />
```

**只有一个自定义属性:dimensionRatio**:宽高比，3:1，前者为宽，后者为高

## 说明

#### 1：确定宽高比的基准，控件的宽高必须有一个为 0dp，另一个即为基准。


|宽高设置|说明|
|--|--|
|`android:layout_width="0dp"`|以高为基准|
|`android:layout_height="0dp"`|以宽为基准|

#### 2：设置宽高比例，如，1:1，前者为宽，后者为高

xml：
`app:dimensionRatio="3:1"`

java：
`ratioImageView.setDimensionRatio(3, 1);`

## License

[MIT](https://github.com/Bakumon/RatioImageView/blob/master/LICENSE)
