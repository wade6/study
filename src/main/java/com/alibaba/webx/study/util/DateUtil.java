package com.alibaba.webx.study.util;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class DateUtil {

    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        String strDate = "";
        Format dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        strDate = dateFormat.format(date);
        return strDate;
    }

    public static String formatYyyyMMdd(Date date) {
        if (date == null) {
            return "";
        }
        Format dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public static String string2Date(String longTime) {
        long time = Long.parseLong(longTime);
        Date date = new Date(time);
        String strDate = "";
        Format dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        strDate = dateFormat.format(date);
        return strDate;
    }

    /**
     * Ĭ��ʱ��֮ǰ����
     * 
     * @param beforeDate
     * @param days ��ǰ����
     * @return
     */
    public static Date dateBefore(String beforeDate, int days) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = format.parse(beforeDate);
            long Time = (date.getTime() / 1000) - 60 * 60 * 24 * days;
            date.setTime(Time * 1000);

        } catch (ParseException e) {
        }
        return date;
    }

    public static Date parseYyyyMMdd(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
        }
        return date;
    }

    /**
     * ��ݵ�ǰ���ڷ���Ĭ��֮ǰ�����ڣ���ȥ�����գ�
     * 
     * @param beforDate
     * @return
     */
    public static Date dateBefore(String beforDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(beforDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (dayOfWeek < 0)
                dayOfWeek = 0;
            if (dayOfWeek == 0) {
                date = DateUtil.dateBefore(beforDate, 4);
            } else if (dayOfWeek == 1) {
                date = DateUtil.dateBefore(beforDate, 5);
            } else if (dayOfWeek == 2) {
                date = DateUtil.dateBefore(beforDate, 5);
            } else if (dayOfWeek == 3) {
                date = DateUtil.dateBefore(beforDate, 5);
            } else if (dayOfWeek == 4) {
                date = DateUtil.dateBefore(beforDate, 3);
            } else if (dayOfWeek == 5) {
                date = DateUtil.dateBefore(beforDate, 3);
            } else {
                date = DateUtil.dateBefore(beforDate, 4);
            }
        } catch (ParseException e) {
        }
        return date;
    }

    /**
     * String ת��ΪDate
     * 
     * @param date
     * @return
     */
    public static Date stringToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date conDate = null;
        try {
            conDate = sdf.parse(date);
        } catch (ParseException e) {

        }
        return conDate;
    }

    /**
     * ��ȡ��һ��
     * 
     * @param dateStr 2011-01-01 00:00:00
     * @return 2011-01-02 00:00:00
     */
    public static String getNextDay(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sf.parse(dateStr);
            return sf.format(getNextDay(date));
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * ��ȡ��һ��
     * 
     * @param dateStr 2011-01-01 00:00:00
     * @return 2011-01-02 00:00:00
     */
    public static Date getNextDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        return c.getTime();
    }
    
    /**
     * ��ȡ����
     * ��ʽΪ��yyyymm
     * @param date
     * @return
     * @author huamo
     */
    public static String getMonth(Date date){
    	if (date == null) {
            return null;
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
        return sf.format(date);
    }
    
    /**
     * ���µ�һ������
     * @return
     */
    public static Date getCurrentMonthStartDate() {
        Calendar ca = Calendar.getInstance();

        ca.setTime(new Date());
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.DAY_OF_MONTH, 1);

        Date firstDate = ca.getTime();

        return firstDate;
    }
    
    /**
     * �������һ������,���һ��
     * @return
     */
    public static Date getCurrentMonthEndDate() {
        Calendar ca = Calendar.getInstance();

        ca.setTime(new Date());
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        ca.add(Calendar.MONTH, 1);
        ca.add(Calendar.DAY_OF_MONTH, -1);

        Date lastDate = new Date(ca.getTime().getTime());

        return lastDate;
    }

    

	public static String formatYyyyMM(Date date) {
		if (date == null) {
			return "";
		}
		Format dateFormat = new SimpleDateFormat("yyyy-MM");
		String strDate = dateFormat.format(date);
		return strDate;
	}


	

	
	
	public static Date parseYyyyMMddHHmmss(String strDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = null;
		try {
			date = format.parse(strDate);
		} catch (ParseException e) {
		}
		return date;
	}
	

	
	

	
	
	/**
	 * 当月最后一天日期,最后一秒
	 * 
	 * @return
	 */
	public static Date getDateLastTime(Date date) {
		Calendar ca = Calendar.getInstance();

		ca.setTime(date);
		ca.set(Calendar.HOUR_OF_DAY, 23);
		ca.set(Calendar.MINUTE, 59);
		ca.set(Calendar.SECOND, 59);
		ca.set(Calendar.MILLISECOND, 0);

		Date lastDate = ca.getTime();

		return lastDate;
	}



	/**
	 * 指定月第一天日期
	 * 
	 * @return
	 */
	public static Date getMonthStartDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar ca = Calendar.getInstance();

		ca.setTime(date);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		ca.set(Calendar.MILLISECOND, 0);
		ca.set(Calendar.DAY_OF_MONTH, 1);

		Date firstDate = ca.getTime();

		return firstDate;
	}

	/**
	 * 指定月最后一天日期,最后一秒
	 * 
	 * @return
	 */
	public static Date getMonthEndDate(Date date) {
		Calendar ca = Calendar.getInstance();

		ca.setTime(date);
		ca.set(Calendar.HOUR_OF_DAY, 23);
		ca.set(Calendar.MINUTE, 59);
		ca.set(Calendar.SECOND, 59);
		ca.set(Calendar.MILLISECOND, 0);
		ca.set(Calendar.DAY_OF_MONTH, 1);
		ca.add(Calendar.MONTH, 1);
		ca.add(Calendar.DAY_OF_MONTH, -1);

		Date lastDate = ca.getTime();

		return lastDate;
	}

	/**
	 * 日期是否在上个月
	 * 
	 * @param date
	 * @return
	 */
	public static boolean beforeCurrentMonth(Date date) {
		Date start = getCurrentMonthStartDate();
		if (start.getTime() > date.getTime()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 日期是否在当前月
	 * 
	 * @param date
	 * @return
	 */
	public static boolean inCurrentMonth(Date date) {
		Date start = getCurrentMonthStartDate();
		Date end = getCurrentMonthEndDate();
		if (start.getTime() <= date.getTime()
				&& end.getTime() >= date.getTime()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 日期是否在下个月
	 * 
	 * @param date
	 * @return
	 */
	public static boolean afterCurrentMonth(Date date) {
		if (date == null) {
			return true;
		}
		Date end = getCurrentMonthEndDate();
		if (end.getTime() < date.getTime()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 获取时间段中以月份为单位的起止时间
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List<Map<String,Object>> getStartEndDateByMonth(Date startDate,Date endDate){
		if(startDate==null ||endDate==null ||startDate.after(endDate)){
			return new ArrayList<Map<String,Object>>();
		}
		
		Calendar startCa = Calendar.getInstance();
		Calendar endCa = Calendar.getInstance();
		
		startCa.setTime(startDate);
		endCa.setTime(endDate);
		
		int startMonth = startCa.get(Calendar.MONTH);
		int endMonth = endCa.get(Calendar.MONTH);
		
		List<Map<String,Object>> monthList = new ArrayList<Map<String,Object>>();
		if(startMonth == endMonth){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("start", startDate);
			map.put("end", endDate);
			monthList.add(map);
			return monthList;
		}else{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("start", startDate);
			map.put("end", getMonthEndDate(startDate));
			monthList.add(map);
		}
		
		for(;startMonth<endMonth-1;startMonth++){
			startCa.add(Calendar.MONTH, 1);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("start", getMonthStartDate(startCa.getTime()));
			map.put("end", getMonthEndDate(startCa.getTime()));
			monthList.add(map);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", getMonthStartDate(endDate));
		map.put("end", endDate);
		monthList.add(map);
		return monthList;
	}
	
	public static void main(String[] args) {
		String start = "2013-01-01 20:00:00";
		String end = "2013-03-11 12:03:40";
		
		List<Map<String,Object>> list = getStartEndDateByMonth(parseYyyyMMddHHmmss(start),parseYyyyMMddHHmmss(end));
		for(Map m : list){
			System.out.println(formatDate((Date) m.get("start"))+" ##"+formatDate((Date) m.get("end")));
		}
		System.out.println(123);
	}
    
}

