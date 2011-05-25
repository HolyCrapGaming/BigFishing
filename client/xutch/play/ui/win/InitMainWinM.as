/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.play.ui.win {
	import flash.display.Sprite;
	import flash.events.Event;

	/**
	 * @author XuTiancheng
	 * 2011-5-23下午11:03:25
	 */
	public class InitMainWinM {
		private var _win : InitMainWin;

		public function InitMainWinM() {
		}

		public function get win() : Sprite {
			return create();
		}

		private function create() : InitMainWin {
			if (_win != null)
				return _win;
			_win = new InitMainWin();
			_win.init();
			_win.func_home = homeHandler;
			_win.func_multi = multiHandler;
			_win.func_single = singleHandler;
			_win.addEventListener(Event.REMOVED_FROM_STAGE, removeHandler);
		}

		private function singleHandler() : void {

		}

		private function multiHandler() : void {

		}

		private function homeHandler() : void {

		}

		private function removeHandler(event : Event) : void {
			_win.dispose();
		}
	}
}