package org.occidere.starbucksmap.vo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.occidere.starbucksmap.utils.JacksonUtils

/**
 * @author occidere
 * @github https://github.com/occidere
 * @blog https://blog.naver.com/occidere
 * @since 2022-03-11
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class Store(
    val sCode: String, // 1509
    val sName: String, // 역삼아레나빌딩
    val tel: String?, //1522-3232
    val fax: String?, //02-568-3763
    val sidoCode: String,// 01
    val sidoName: String,// 서울
    val gugunCode: String?,// 0101
    val gugunName: String?,// 강남구
    val addr: String?,// 서울특별시 강남구 역삼동 721-13 아레나빌딩
    val sBizCode: String, // 3762 (store time api 에서 사용)
    @JsonProperty("defaultimage")
    val defaultImage: String?,// /upload/store/2020/09/[3762]_20200917031519_6juwr.JPG
    val openDt: String?,// 20190613
    val doroAddress: String?,// 서울특별시 강남구 언주로 425 (역삼동)
    val storeAreaCode: String?,// A01
    val lat: String,// 37.501087
    val lot: String,// 127.043069
    val location: String = "$lat,$lot",
    val createdAt: Long = System.currentTimeMillis()
) {
    override fun toString(): String = JacksonUtils.OBJECT_MAPPER.writeValueAsString(this)
}

/*
{
  "seq": 0,
  "sido_cd": null,
  "sido_nm": null,
  "gugun_cd": null,
  "gugun_nm": null,
  "code_order": null,
  "view_yn": null,
  "store_num": null,
  "sido": null,
  "gugun": null,
  "address": null,
  "new_img_nm": null,
  "p_pro_seq": 0,
  "p_view_yn": null,
  "p_sido_cd": "
  "p_gugun_cd": "
  "p_store_nm": null,
  "p_theme_cd": null,
  "p_wireless_yn": null,
  "p_smoking_yn": null,
  "p_book_yn": null,
  "p_music_yn": null,
  "p_terrace_yn": null,
  "p_table_yn": null,
  "p_takeout_yn": null,
  "p_parking_yn": null,
  "p_dollar_assent": null,
  "p_card_recharge": null,
  "p_subway_yn": null,
  "stb_store_file_renew": null,
  "stb_store_theme_renew": null,
  "stb_store_time_renew": null,
  "stb_store_lsm": null,
  "s_code": "1509
  "s_name": "역삼아레나빌딩
  "tel": "1522-3232
  "fax": "02-568-3763
  "sido_code": "01
  "sido_name": "서울
  "gugun_code": "0101
  "gugun_name": "강남구
  "addr": "서울특별시 강남구 역삼동 721-13 아레나빌딩
  "park_info": null,
  "new_state": null,
  "theme_state": "T05@T08@T16@T17@T20@T21@T30@@T52@P80@P90
  "new_bool": 0,
  "search_text": "
  "ins_lat": "
  "ins_lng": "
  "in_distance": 0,
  "out_distance": null,
  "all_search_cnt": -1,
  "addr_search_cnt": -1,
  "store_search_cnt": -1,
  "rowCount": 30,
  "store_nm": "
  "store_cd": 0,
  "s_biz_code": "3762"
  "new_icon": "N
  "set_user": "
  "favorites": 0,
  "map_desc": null,
  "notice": null,
  "defaultimage": "/upload/store/2020/09/[3762]_20200917031519_6juwr.JPG
  "etcimage": null,
  "in_biz_cd": null,
  "in_store_cd": null,
  "in_favorites": null,
  "in_user_id": null,
  "in_biz_cds": 0,
  "in_biz_arr": null,
  "in_biz_arrdata": null,
  "in_scodes": 0,
  "in_scode_arr": null,
  "in_scode_arrdata": null,
  "disp": null,
  "set_date": null,
  "hlytag": null,
  "hlytag_msg": null,
  "vSal": "
  "istart": 1,
  "iend": 60,
  "open_dt": "20190613
  "gold_card": 0,
  "ip_lat": "
  "ip_long": "
  "espresso": "
  "new_store": "
  "premiere_food": "
  "doro_address": "서울특별시 강남구 언주로 425 (역삼동)
  "cold_blew": "
  "my_siren_order_store_yn": "N
  "whcroad_yn": "WHCROAD
  "skuNo": "
  "skuName": "
  "skuImgUrl": "
  "stock_count": 0,
  "store_area_name": null,
  "store_area_code": "A01
  "is_open": null,
  "gift_stock_yn": null,
  "lat": "37.501087
  "lot": "127.043069
  "location": "37.501087,127.043069
  "t20": 0,
  "t04": 0,
  "t03": 0,
  "t01": 0,
  "t12": 0,
  "t09": 0,
  "t06": 0,
  "t10": 0,
  "p10": 0,
  "p50": 0,
  "p20": 0,
  "p60": 0,
  "p30": 0,
  "p70": 0,
  "p40": 0,
  "p80": 0,
  "t22": 0,
  "t21": 0,
  "p90": 0,
  "t05": 0,
  "t30": 0,
  "t36": 0,
  "t27": 0,
  "t29": 0,
  "t43": 0,
  "t48": 0
}
 */