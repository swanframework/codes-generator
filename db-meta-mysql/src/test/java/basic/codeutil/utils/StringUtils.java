package basic.codeutil.utils;
/**
 * @ClassName: StringUtils 
 * @Description: 字符串工具类
 * @author: tiansn
 * @date: 2015年12月22日 下午2:27:10
 */
public class StringUtils {
	
	/**
	 * 判断字符串是否以指定字符串开头
	 * @param str 
	 * @param prefix 
	 * @return
	 * @return: boolean
	 * @author: tiansn
	 * @time: 2015年12月22日 下午2:27:21
	 */
	public static boolean startsWith(String str, String prefix){
		int index = str.indexOf(prefix);
		if(index == 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 截取指定字符串后面的字符串
	 * @param str
	 * @param prefix
	 * @return
	 * @return: String
	 * @author: tiansn
	 * @time: 2015年12月22日 下午2:27:56
	 */
	public static String substringAfter(String str, String prefix){
		int index = str.indexOf(prefix);
		return str.substring(index + prefix.length(), str.length());
	}
	
	/**
	 * 截取指定字符串前面的字符串
	 * @param str
	 * @param prefix
	 * @return
	 * @return: String
	 * @author: tiansn
	 * @time: 2015年12月22日 下午2:28:36
	 */
	public static String substringBefore(String str, String prefix){
		int index = str.indexOf(prefix);
		return str.substring(0, index);
	}
	
	
	/**
	 * 截取指定字符串前面的字符串
	 * @param str
	 * @param prefix
	 * @return
	 * @return: String
	 * @author: tiansn
	 * @time: 2015年12月22日 下午2:28:36
	 */
	public static String substringBeforeLast(String str, String prefix){
		int index = str.lastIndexOf(prefix);
		return str.substring(0, index);
	}
	
	/**
	 *  截取指定字符串最后一次出现后面的字符串
	 * @param str
	 * @param prefix
	 * @return
	 */
	public static String substringAfterLast(String str, String prefix){
		int index = str.lastIndexOf(prefix);
		return str.substring(index + prefix.length(), str.length());
	}

	/**
	 * 首字母大写
	 * @param str 字符串
	 * @return String
	 */
	public static String upperFirst(String str){
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	/**
	 * 首字母小写
	 * @param str
	 * @return
	 */
	public static String lowwerFirst(String str){
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}
}
