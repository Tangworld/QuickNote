百度地图Android SDK自v2.3.0起，采用可定制的形式为您提供开发包，当前开发包包含如下功能:
基础地图：地图显示、操作和各种覆盖物图层：
检索功能：POI检索、地理编码、路径规划等；
LBS云检索：基于LBS云的周边、城市内、区域、详情检索；
计算工具：调启百度地图客户端导航、调启Web App导航、计算距离等；
周边雷达：包含位置信息上传和检索周边相同应用的用户位置信息功能；
百度地图Android SDK自v2.3.0起，采用可定制的形式为您提供开发包，当前开发包包含如下功能:

基础地图：地图显示、操作和各种覆盖物图层：

检索功能：POI检索、地理编码、路径规划等；

LBS云检索：基于LBS云的周边、城市内、区域、详情检索；

计算工具：调启百度地图客户端导航、调启Web App导航、计算距离等；

周边雷达：包含位置信息上传和检索周边相同应用的用户位置信息功能；

------------------------------------------------------------------------------------------------

Android 地图 SDK v3.7.0是适用于Android系统移动设备的矢量地图开发包

------------------------------------------------------------------------------------------------
注意：为了给用户提供更安全的服务，Android SDK自v2.1.3版本开始采用了全新的Key验证体系。因此，当您选择使用v2.1.3及之后版本的SDK时，需要到新的Key申请页面进行全新Key的申请，申请及配置流程请参考开发指南的对应章节。（选择使用v2.1.2及之前版本SDK的开发者，申请密钥（Key） 的方式不变）
------------------------------------------------------------------------------------------------
地图SDK功能介绍（全功能开发包）：

地图：
	提供地图（2D、3D）的展示和缩放、平移、旋转、改变视角等地图操作；
POI检索：
	可根据关键字，对POI数据进行周边、区域和城市内三种检索；
地理编码：
	提供地理坐标和地址之间相互转换的能力；
线路规划：
	支持公交信息查询、公交换乘查询、驾车线路规划和步行路径检索；
覆盖物：
	提供多种地图覆盖物（瓦片图层、自定义标注、几何图形、文字绘制、地形图图层、热力图图层等），满足开发者的各种需求；
定位：
	采用多种定位模式，使用定位SDK获取位置信息，使用地图SDK我的位置图层进行位置展示；
离线地图：
	支持使用离线地图，节省用户流量，同时为用户带来更好的地图体验；
调启百度地图：
	利用SDK接口，直接在本地打开百度地图客户端或WebApp，实现地图功能。
周边雷达：
	利用周边雷达功能，开发者可在App内低成本、快速实现查找周边使用相同App的用户位置的功能。
LBS云检索：
	支持用户检索存储在LBS云内的自有POI数据，并展示；
特色功能：
	提供短串分享、Place详情检索、热力图等特色功能，帮助开发者搭建功能更加强大的应用；
------------------------------------------------------------------------------------------------

【新版提示】

	
1、自v3.6.0起，官网不再支持地图离线包下载，所以SDK去掉“手动导入离线包接口”，SDK在线下载离线包接口仍维持不变。
	

2、因为新版采用新的分包形式，旧包无法与新包同时混用，请将之前所有旧包（so和jar）全部替换为新包。
	

3、自V3.6.0起，Android SDK使用新的矢量地图样式，地图显示更加清新，和百度地图客户端保持一致。
	

4、自V3.6.0起，原内置覆盖物相关类代码开源（OverlayManager/PoiOverlay/TransitRouteOverlay/WalkingRouteOverlay/BusLineOverlay）,源码可在BaiduMapsApiDemo工程中找到。

	
5、自V3.6.0起，Android SDK采用功能包拆分的形式，

其中:
baidumapapi_base_vX_X_X.jar和libBaiduMapSDK_base_vX_X_X.so为基础包，使用地图、检索、云检索、工具、周边雷达中任何一功能都必须包含；


baidumapapi_map_vX_X_X.jar和libBaiduMapSDK_map_vX_X_X.so为地图功能包；
baidumapapi_search_vX_X_X.jar和libBaiduMapSDK_search_vX_X_X.so为检索功能包；


baidumapapi_cloud_vX_X_X.jar和libBaiduMapSDK_cloud_vX_X_X.so为云检索功能包；
baidumapapi_util_vX_X_X.jar和libBaiduMapSDK_util_vX_X_X.so为工具功能包；


baidumapapi_radar_vX_X_X.jar和libBaiduMapSDK_radar_vX_X_X.so为周边雷达工具包；


如果您从http://lbsyun.baidu.com/sdk/download这里下载的开发包，提供给您的将所有jar打包成BaiduLBS_Android.jar。native动态库so的形式不变。


较之v3.6.1，升级功能：


【 新 增 】


 [基础地图]


1、 新增个性化地图模板

          MapView/TextureMapView 新增setCustomMapStylePath(String customMapStylePath),设置自定义地图样式文件绝对路径

2、 新增设置地图边界区域的方法setPadding， logo、比例尺、指南针和缩放按钮等控件将调整在地图边界区域内，同时自适应MapStatus中心点坐标由屏幕中心点调整至设置的边界区域中心点 

          BaiduMap新增 setPadding(int left, int top, int right, int bottom),需在OnMapLoadedCallback.onMapLoaded() 回调内设置才生效 

3、 支持地图缩放至21级，但不支持卫星图、热力图、交通路况图层的21级显示。

4、 新增地图None 类型，不加载百度地图瓦片，显示为空白屏幕。和瓦片图功能配合使用减少数据加载，提升显示速度，节省流量 

         BaiduMap新增MAP_TYPE_NONE 

5、 新增设置地图显示范围的方法。（当前不支持旋转地图的情况，请与禁用旋转手势配合使用。）

         BaiduMap新增setMapStatusLimits(LatLngBounds bounds),需在OnMapLoadedCallback.onMapLoaded() 回调内设置才生效。  

6、 新增获取百度logo位置的方法，支持调整百度logo位置，使用枚举类型控制显示的位置，共支持6个位置

         MapView/TextureMapView 新增接口setLogoPosition(LogoPosition position),枚举类LogoPosition支持屏幕6个位置 

7、 新增MapView/TextureMapView 横竖屏切换方法，可实现横竖屏切换保存地图状态。

         MapView\TextureMapView 新增方法 onSaveInstanceState(Bundle bundle) 

   onCreate(Context context, Bundle bundle) 

         用户重载这个方法时必须调用父类的这个方法。 

8、 新增获取指南针位置的方法。 BaiduMap新增getCompassPosition()获取指南针的屏幕坐标。 

9、 新增获取比例尺控件宽度、高度方法。

          MapView/TextureMapView新增方法getScaleControlViewHeight() getScaleControlViewWidth() 获取比例尺的宽度、高度。 

10、新增自定义定位精度圈的填充颜色和边框 

          MyLocationConfiguration新增重载构造方法 MyLocationConfiguration(LocationMode mode, boolean enableDirection, BitmapDescriptor customMarker, int accuracyCircleFillColor, int accuracyCircleStrokeColor)  

11、新增批量增加marker点，优化添加大量Marker点时的性能 

         BaiduMap新增 addOverlays(List<OverlayOptions> options) 

12、支持获取指定区域内所有marker点 BaiduMap新增 getMarkersInBounds(LatLngBounds bounds)


[检索功能]


1、 新增骑行路线规划

         新增类BikingRouteLine表示一条骑行路线；类BikingRoutePlanOption表示骑行检索Option，传入起终点信息；类BikingRouteResult表示骑行路线检索结果

         RoutePlanSearch新增接口 bikingSearch(BikingRoutePlanOption option) 发起骑行路线检索

2、 新增驾车、公交、骑行、步行路径规划结果的短串分享功能。

         ShareUrlSearch 新增 requestRouteShareUrl(RouteShareURLOption option) 发起路线规划短串分享请求

         新增类 RouteShareURLOption 设置路线起终点参数、枚举类RouteShareMode 设置路线规划类型，包含驾车、步行、骑行、公交 短串分享

3、 新增行政区边界数据检索，并开源绘制行政区域多边形代码。

         新增类：DistrictSearch 发起行政区域检索

         新增类：DistrictSearchOption 行政区域检索请求参数

         新增类：DistrictResult 行政区域检索结果类

         新增类：OnGetDistricSearchResultListener 行政区域检索结果回调接口

         
【 Bug 修 复 】 
         
1、 修复地图在Dialog中显示崩溃。

2、 增加鉴权判空容错。

3、 修复在一些特定ROM上调起百度地图客户端失败，增加容错机制。

4、 修复TextureMapView showInfoWindow失败。

5、 优化TextureMapView内存问题。

6、 修复地图手势操作的空指针引起的偶现crash。

