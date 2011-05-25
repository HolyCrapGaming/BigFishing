/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.play.ui.bar {
	import flash.events.Event;

	import xutch.Xutch;
	import xutch.data.userInfo.UserInfoEventName;

	/**
	 * @author XuTiancheng
	 * 2011-5-24下午12:21:43
	 */
	public class UserInfoM {
		private var _userInfo : UserInfo;

		public function UserInfoM() {
		}

		public function init() : void {
			_userInfo = new UserInfo();
			_userInfo.init();
			Xutch.ins.dataM.userInfoM.dispatcher.addEventListener(UserInfoEventName.USEREVT_UPDATAGOLD, updataGoldHandler);
		}

		private function updataGoldHandler(event : Event) : void {
			//			Xutch.ins.dataM.userInfoM.mainUesrGold
		}
	}
}