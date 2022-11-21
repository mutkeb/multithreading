package com.youkeda.test.j5c4s5p1;

import com.alibaba.fastjson.JSON;
import com.youkeda.test.j5c4s5p1.model.WeatherData;
import com.youkeda.test.j5c4s5p1.model.Weather;

public class WeatherNotice {

    public static void main(String[] args) {
        WeatherPicker wp = new WeatherPicker();
        String content = wp.pick();
        Weather weather = JSON.parseObject(content, Weather.class);
        String cityName = weather.getWeatherinfo().getCity();
        String temp = weather.getWeatherinfo().getTemp();
        String time = weather.getWeatherinfo().getTime();
        //  补充天气数据
        WeatherData weatherData = new WeatherData(cityName);

        //  邮件观察者
        WeatherObserver w1 = new WeatherObserver();
        w1.setName("天气邮件观察者");

        //  短信观察者
        WeatherObserver w2 = new WeatherObserver();
        w2.setName("天气短信观察者");

        //  添加观察者
        weatherData.addObserver(w1);
        weatherData.addObserver(w2);

        // 气温变化
        weatherData.changeTemp("11:08", "32.8");
        // 气温变化
        weatherData.changeTemp("14:46", "29.3");

    }
}