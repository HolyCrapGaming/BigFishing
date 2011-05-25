/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.data.userInfo {
	import xutch.xutchClass.SmartEventDispatcher;

	/**
	 * @author XuTiancheng
	 * 2011-5-24上午11:45:47
	 * 用户信息管理
	 */
	public class UserInfoManager implements IUserInfoManager {
		private var _vo_mainUserInfo : UserInfoVO;
		private var _dispatcher : SmartEventDispatcher;

		public function UserInfoManager() {
		}

		public function updataUserGold(num : int) : void {
			_vo_mainUserInfo.int_gold += num;
			dispatcher.dispatchEventSmart(UserInfoEventName.USEREVT_UPDATAGOLD);
		}

		public function get mainUesrGold() : int {
			return _vo_mainUserInfo.int_gold;
		}

		public function init() : void {
			_dispatcher = new SmartEventDispatcher();
		}

		public function get dispatcher() : SmartEventDispatcher {
			return _dispatcher;
		}
	}
}