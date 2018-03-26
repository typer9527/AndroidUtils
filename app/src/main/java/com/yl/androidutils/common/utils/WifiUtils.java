package com.yl.androidutils.common.utils;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.util.Log;

/**
 * wifi工具类
 */
public class WifiUtils {

    private WifiManager localWifiManager;//提供Wifi管理的各种主要API，主要包含wifi的扫描、建立连接、配置信息等
    //private List<ScanResult> wifiScanList;//ScanResult用来描述已经检测出的接入点，包括接入的地址、名称、身份认证、频率、信号强度等
    private List<WifiConfiguration> wifiConfigList;//WIFIConfiguration描述WIFI的链接信息，包括SSID、SSID隐藏、password等的设置
    private WifiInfo wifiConnectedInfo;//已经建立好网络链接的信息
    private WifiLock wifiLock;//手机锁屏后，阻止WIFI也进入睡眠状态及WIFI的关闭

    public WifiUtils(Context context) {
        localWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    /**
     * 检查WIFI状态
     *
     * @return
     */
    public int wifiState() {
        return localWifiManager.getWifiState();
    }

    /**
     * 开启WIFI
     */
    public void openWifi() {
        if (!localWifiManager.isWifiEnabled()) {
            localWifiManager.setWifiEnabled(true);
        }
    }

    /**
     * 关闭WIFI
     */
    public void closeWifi() {
        if (!localWifiManager.isWifiEnabled()) {
            localWifiManager.setWifiEnabled(false);
        }
    }

    /**
     * 扫描wifi
     */
    public void wifiStartScan() {
        localWifiManager.startScan();
    }

    /**
     * 得到Scan结果
     *
     * @return
     */
    public List<ScanResult> getScanResults() {
        return localWifiManager.getScanResults();//得到扫描结果
    }

    /**
     * Scan结果转为Sting
     *
     * @param list
     * @return
     */
    public List<String> scanResultToString(List<ScanResult> list) {
        List<String> strReturnList = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            ScanResult strScan = list.get(i);
            String str = strScan.toString();
            boolean bool = strReturnList.add(str);
            if (!bool) {
                Log.i("scanResultToSting", "Addfail");
            }
        }
        return strReturnList;
    }

    /**
     * 得到Wifi配置好的信息
     */
    public void getConfiguration() {
        wifiConfigList = localWifiManager.getConfiguredNetworks();//得到配置好的网络信息
        for (int i = 0; i < wifiConfigList.size(); i++) {
            Log.i("getConfiguration", wifiConfigList.get(i).SSID);
            Log.i("getConfiguration", String.valueOf(wifiConfigList.get(i).networkId));
        }
    }

    /**
     * 判定指定WIFI是否已经配置好,依据WIFI的地址BSSID,返回NetId
     *
     * @param SSID
     * @return
     */
    public int IsConfiguration(String SSID) {
        Log.i("IsConfiguration", String.valueOf(wifiConfigList.size()));
        for (int i = 0; i < wifiConfigList.size(); i++) {
            Log.i(wifiConfigList.get(i).SSID, String.valueOf(wifiConfigList.get(i).networkId));
            if (wifiConfigList.get(i).SSID.equals(SSID)) {//地址相同
                return wifiConfigList.get(i).networkId;
            }
        }
        return -1;
    }

    /**
     * 添加指定WIFI的配置信息,原列表不存在此SSID
     *
     * @param wifiList
     * @param ssid
     * @param pwd
     * @return
     */
    public int AddWifiConfig(List<ScanResult> wifiList, String ssid, String pwd) {
        int wifiId = -1;
        for (int i = 0; i < wifiList.size(); i++) {
            ScanResult wifi = wifiList.get(i);
            if (wifi.SSID.equals(ssid)) {
                Log.i("AddWifiConfig", "equals");
                WifiConfiguration wifiCong = new WifiConfiguration();
                wifiCong.SSID = "\"" + wifi.SSID + "\"";//\"转义字符，代表"
                wifiCong.preSharedKey = "\"" + pwd + "\"";//WPA-PSK密码
                wifiCong.hiddenSSID = false;
                wifiCong.status = WifiConfiguration.Status.ENABLED;
                wifiId = localWifiManager.addNetwork(wifiCong);//将配置好的特定WIFI密码信息添加,添加完成后默认是不激活状态，成功返回ID，否则为-1
                if (wifiId != -1) {
                    return wifiId;
                }
            }
        }
        return wifiId;
    }

    /**
     * 连接指定Id的WIFI
     *
     * @param wifiId
     * @return
     */
    public boolean ConnectWifi(int wifiId) {
        for (int i = 0; i < wifiConfigList.size(); i++) {
            WifiConfiguration wifi = wifiConfigList.get(i);
            if (wifi.networkId == wifiId) {
                while (!(localWifiManager.enableNetwork(wifiId, true))) {//激活该Id，建立连接
                    Log.i("ConnectWifi", String.valueOf(wifiConfigList.get(wifiId).status));
                    //status:0--已经连接，1--不可连接，2--可以连接
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 创建一个WIFILock
     *
     * @param lockName
     */
    public void createWifiLock(String lockName) {
        wifiLock = localWifiManager.createWifiLock(lockName);
    }

    /**
     * 锁定wifilock
     */
    public void acquireWifiLock() {
        wifiLock.acquire();
    }

    /**
     * 解锁WIFI
     */
    public void releaseWifiLock() {
        if (wifiLock.isHeld()) {//判定是否锁定
            wifiLock.release();
        }
    }

    /**
     * 得到建立连接的信息
     */
    public void getConnectedInfo() {
        wifiConnectedInfo = localWifiManager.getConnectionInfo();
    }

    /**
     * 得到连接的MAC地址
     *
     * @return
     */
    public String getConnectedMacAddr() {
        return (wifiConnectedInfo == null) ? "null" : wifiConnectedInfo.getMacAddress();
    }

    /**
     * 得到连接的名称SSID
     *
     * @return
     */
    public String getConnectedSSID() {
        return (wifiConnectedInfo == null) ? "null" : wifiConnectedInfo.getSSID();
    }

    /**
     * 得到连接的IP地址
     *
     * @return
     */
    public int getConnectedIPAddr() {
        return (wifiConnectedInfo == null) ? 0 : wifiConnectedInfo.getIpAddress();
    }

    /**
     * 得到连接的ID
     *
     * @return
     */
    public int getConnectedID() {
        return (wifiConnectedInfo == null) ? 0 : wifiConnectedInfo.getNetworkId();
    }
}
