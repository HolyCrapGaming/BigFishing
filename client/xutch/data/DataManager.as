/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.data {
	import xutch.data.userInfo.IUserInfoManager;
	import xutch.data.userInfo.UserInfoManager;

	/**
	 * @author XuTiancheng
	 * 2011-5-24上午11:51:36
	 * 数据信息管理
	 */
	public class DataManager implements IDataManager {
		private var _userInfoM : UserInfoManager;

		public function DataManager() {
		}

		public function init() : void {
			_userInfoM = new UserInfoManager();
		}

		public function get userInfoM() : IUserInfoManager {
			return _userInfoM;
		}
	}
}