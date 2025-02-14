package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{yyyymmdd}")
    public String dispDayOfweek(@PathVariable("yyyymmdd") String ymd) {
        // 仕様1:日付文字列をURLから取得

        // 確認用に文字列のまま切り出し + 返す
        // 終了位置は最後の文字 +1 で位置を指定する（模様）
//      String year =  ymd.substring(0,4);
//      String month = ymd.substring(4,6);

        //末尾から取得するときはこう書く（らしい）
//      String date = ymd.substring(ymd.length()-2);
//
//      return "年は "+ year + " 月は "+ month + " 日は "+ date + " です。";

        // ここから課題本番用
        // 年・月・日を切り出す + int型に変換
        // 終了位置は最後の文字 +1 で位置を指定する（模様）
        // 終了位置の1つ手前のところまで切り出す（模様）

        int year =  (Integer.parseInt(ymd.substring(0,4)));

        // カレンダー型のmonthは0-11のため、-1する（初回提出のとき、書き忘れた）
        int month = Integer.parseInt(ymd.substring(4,6))-1;

        // 末尾から取得するときはこう書く（らしい）
        int date = Integer.parseInt(ymd.substring(ymd.length()-2));

        // 年・月・日から曜日を取得（カレンダー型を使うらしい）
        Calendar cal = Calendar.getInstance();

        // 取得した値で曜日分岐
        cal.set(year,month, date);
        switch(cal.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:
                return "Sunday";
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            //defaultを書かないと文字列のreturnがあると認識されない模様（詳しい理由は後で確認）
            default:
                return "表示するものはないよ";
        }
    }

    // 仕様2
    // 足し算
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable("val1") int val1,@PathVariable("val2") int val2){
        // 計算
        int res_int = 0;
        res_int = val1 + val2;

        // 計算結果を文字列に変換して返す
        String res_str = String.valueOf(res_int);
        return res_str;
    }

    // 引き算
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable("val1") int val1,@PathVariable("val2") int val2){
        //　計算
        int res_int = 0;
        res_int = val1 - val2;

        // 計算結果を文字列に変換して返す
        String res_str = String.valueOf(res_int);
        return res_str;
    }

    // 掛け算
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable("val1") int val1,@PathVariable("val2") int val2){
        //　計算
        int res_int = 0;
        res_int = val1 * val2;

        // 計算結果を文字列に変換して返す
        String res_str = String.valueOf(res_int);
        return res_str;
    }

    // 割り算
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable("val1") int val1,@PathVariable("val2") int val2){
        //　計算
        int res_int = 0;
        res_int = val1 / val2;

        // 計算結果を文字列に変換して返す
        String res_str = String.valueOf(res_int);
        return res_str;
    }

}
