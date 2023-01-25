package com.lavasoft;

import java.util.*;
/**
 * @author vkiprono
 * @created 1/24/23
 */

public class IpLocator {

    public static void main(String[] args) {
        System.out.println("Please enter the ip address: ");
        Scanner input = new Scanner(System.in);
        String ipAddress = input.next();
        System.out.println("The country for :" + ipAddress + " is : " + getIpLocation(ipAddress));

        /**
         * Examples of IPs :
         * 198.16.70.53 - NL
         * 41.139.128.79 - KE
         */

    }

    public static String getIpLocation(String ipAddress){
        String country = null;
        if (ipAddress == null || ipAddress.isEmpty()){
            return "Please enter an IP address";
        }
        else {
            GeoIPService geoIPService = new GeoIPService();
            GeoIPServiceSoap geoIPServiceSoap = geoIPService.getGeoIPServiceSoap();
            country = geoIPServiceSoap.getIpLocation(ipAddress);
        }

        return country;
    }
}
