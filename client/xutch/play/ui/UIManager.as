/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.play.ui {
	import xutch.play.ui.log.LogManager;
	import xutch.play.ui.pupup.IPopupManager;
	import xutch.play.ui.pupup.PopupManager;

	/**
	 * @author XuTiancheng
	 * 2011-5-24下午12:49:46
	 * ui总管理
	 */
	public class UIManager implements IUIManager {
		private var _popupM : PopupManager;
private var _logM:LogManager;
		public function UIManager() {
		}

		public function get popupM() : IPopupManager {
			return _popupM;
		}
		public function get logM():
		{
			
		}
	}
}