/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.data {
	import xutch.data.userInfo.IUserInfoManager;

	/**
	 * @author XuTiancheng
	 * 上午11:56:27
	 */
	public interface IDataManager {
		function init() : void ;
		
		function get userInfoM() : IUserInfoManager ;
	}
}