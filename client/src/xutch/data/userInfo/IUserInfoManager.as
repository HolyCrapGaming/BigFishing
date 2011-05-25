/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.data.userInfo {
	import xutch.xutchClass.SmartEventDispatcher;

	/**
	 * @author XuTiancheng
	 * 上午11:54:29
	 * 用户信息管理
	 */
	public interface IUserInfoManager {
		/**
		 * @param num 正+  负-  会发出evt USEREVT_UPDATAGOLD
		 */
		function updataUserGold(num : int) : void;

		function init() : void;

		function get dispatcher() : SmartEventDispatcher;
		/**
		 * @return 获取登陆玩家的金币数目
		 */
		function get mainUesrGold() : int;
	}
}