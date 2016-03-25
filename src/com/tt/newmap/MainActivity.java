package com.tt.newmap;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.tt.entity.Item;
import com.tt.utils.SqlService1;

public class MainActivity extends Activity {

	@SuppressWarnings("unused")
	private static final String LTAG = MainActivity.class.getSimpleName();
	private MapView mMapView;
	private BaiduMap mBaiduMap;
	BitmapDescriptor bitmap;
	private String address = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// mMapView = new MapView(this, new BaiduMapOptions());
		// setContentView(mMapView);// ��ʱ��M<span
		// style="font-family:KaiTi_GB2312;">ap</span>View�ʹ�����һ��AndroidӦ���еĲ����ļ�
		setContentView(R.layout.activity_main);
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
		mBaiduMap.setMyLocationEnabled(true);
		init();
		LatLng cenpt = new LatLng(31.9206520000, 118.7926770000);
		// �����ͼ״̬
		MapStatus mMapStatus = new MapStatus.Builder().target(cenpt).zoom(18)
				.build();
		// ����MapStatusUpdate�����Ա�������ͼ״̬��Ҫ�����ı仯
		MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory
				.newMapStatus(mMapStatus);
		// �ı��ͼ״̬
		mBaiduMap.setMapStatus(mMapStatusUpdate);
		bitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_marka);
		mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {
			
			@Override
			public boolean onMarkerClick(Marker marker) {
				LatLng markerposition = marker.getPosition();
				String latitude = String.valueOf(markerposition.latitude);
				String longitude = String.valueOf(markerposition.longitude);
				String username = getIntent().getStringExtra("username");
				String password = getIntent().getStringExtra("password");
				Intent intent = new Intent(getApplicationContext(),ReeditActivity.class);
				intent.putExtra("username", username);
				intent.putExtra("password", password);
				intent.putExtra("latitude", latitude);
				intent.putExtra("longitude", longitude);
				startActivity(intent);
				return true;
			}
		});
		mBaiduMap.setOnMapClickListener(new OnMapClickListener() {

			@Override
			public boolean onMapPoiClick(MapPoi arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			// �˷������ǵ����ͼ����
			@Override
			public void onMapClick(LatLng latLng) {
				// ��ȡ��γ��
				String latitude = String.valueOf(latLng.latitude);
				String longitude = String.valueOf(latLng.longitude);
				System.out.println("latitude=" + latitude + ",longitude="
						+ longitude);
				
				
				// �����ͼ��
				// mBaiduMap.clear();
				// ����Maker�����
				LatLng point = new LatLng(latLng.latitude, latLng.longitude);
				// ����MarkerOption�������ڵ�ͼ�����Marker
				MarkerOptions options = new MarkerOptions().position(point)
						.icon(bitmap);
				// tsj��ʵ�ֵ���󵯳��༭��
				/*View popupView = getLayoutInflater().inflate(
						R.layout.popupwindow, null);
				PopupWindow mPopupWindow = new PopupWindow(popupView,
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT,
						true);
				mPopupWindow.setTouchable(true);
				mPopupWindow.setOutsideTouchable(true);
				mPopupWindow.setBackgroundDrawable(new BitmapDrawable(
						getResources(), (Bitmap) null));*/
				//mPopupWindow.showAsDropDown();
				// �ڵ�ͼ�����Marker������ʾ
				mBaiduMap.addOverlay(options);
				// ʵ����һ����������ѯ����
				GeoCoder geoCoder = GeoCoder.newInstance();
				// ���÷��������λ������
				ReverseGeoCodeOption op = new ReverseGeoCodeOption();
				op.location(latLng);
				// ���𷴵����������(��γ��->��ַ��Ϣ)
				geoCoder.reverseGeoCode(op);
				geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {

					@Override
					public void onGetReverseGeoCodeResult(
							ReverseGeoCodeResult arg0) {
						// ��ȡ����������ַ
						address = arg0.getAddress();
						System.out.println("address=" + address);
					}

					@Override
					public void onGetGeoCodeResult(GeoCodeResult arg0) {
					}
				});
				//�����༭activity
				Intent intent = new Intent(MainActivity.this,EditActivity.class);
				intent.putExtra("username", getIntent().getStringExtra("username"));
				intent.putExtra("password", getIntent().getStringExtra("password"));
				intent.putExtra("latitude", latitude.toString());
				intent.putExtra("longitude", longitude);
				System.out.println("mainactivity  "+latitude+"  "+longitude);
				startActivity(intent);
			}
		});
	}
	
	private void init(){
		List<Item> items=new ArrayList<Item>();
		System.out.println(getIntent().getStringExtra("password"));
		items=getData(getIntent().getStringExtra("password"));
		for(Item i:items){
			String latitude = i.getLatitude();
			String longitude = i.getLongitude();
			System.out.println("username"+i.getUsername());
			System.out.println("password"+i.getPassword());
			System.out.println("��ǣ�----->latitude:"+latitude+"   longitude:"+longitude);
			System.out.println("���ݣ�------>"+i.getContent());
			if(latitude != null && !"".equals(latitude.trim())&&longitude != null && !"".equals(longitude.trim())){
				double dlatitude = Double.parseDouble(latitude);
				double dlongitude = Double.parseDouble(longitude);
				LatLng point = new LatLng(dlatitude, dlongitude);  
				//����Markerͼ��  
				BitmapDescriptor bitmap = BitmapDescriptorFactory  
				    .fromResource(R.drawable.icon_marka);  
				//����MarkerOption�������ڵ�ͼ�����Marker  
				OverlayOptions option = new MarkerOptions()  
				    .position(point)  
				    .icon(bitmap);  
				//�ڵ�ͼ�����Marker������ʾ  
				mBaiduMap.addOverlay(option);
			}
		/*	double dlatitude = Double.parseDouble(latitude);
			double dlongitude = Double.parseDouble(longitude);
			LatLng point = new LatLng(dlatitude, dlongitude);  
			//����Markerͼ��  
			BitmapDescriptor bitmap = BitmapDescriptorFactory  
			    .fromResource(R.drawable.icon_marka);  
			//����MarkerOption�������ڵ�ͼ�����Marker  
			OverlayOptions option = new MarkerOptions()  
			    .position(point)  
			    .icon(bitmap);  
			//�ڵ�ͼ�����Marker������ʾ  
			mBaiduMap.addOverlay(option);*/
			
		}
	}
	private List<Item> getData(String password){
		String sql="select * from contenttable where password="+password;
		List<Item> items=new ArrayList<Item>();
		SqlService1 query = new SqlService1(getApplicationContext());
		items = query.findbysql(sql);
		return items;
	}

	@Override
	protected void onPause() {
		super.onPause();
		// activity ��ͣʱͬʱ��ͣ��ͼ�ؼ�
		mMapView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// activity �ָ�ʱͬʱ�ָ���ͼ�ؼ�
		mMapView.onResume();
		//init();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// activity ����ʱͬʱ���ٵ�ͼ�ؼ�
		mMapView.onDestroy();
	}
	
	
	
}
