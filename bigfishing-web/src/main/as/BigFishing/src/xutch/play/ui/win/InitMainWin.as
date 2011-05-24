/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.play.ui.win {
	import flash.display.Sprite;
	import flash.events.Event;

	import xutch.xutchClass.BaseButtonEvent;
	import xutch.xutchClass.DisplayObjUtils;
	import xutch.xutchClass.IBaseButton;

	/**
	 * @author XuTiancheng
	 * 2011-5-23下午10:46:18
	 * 游戏初始化后的主界面
	 */
	public class InitMainWin extends Sprite {
		//btns
		private var _btn_single : IBaseButton;
		private var _btn_multi : IBaseButton;
		private var _btn_home : IBaseButton;
		//funcs
		private var _func_single : Function;
		private var _func_home : Function;
		private var _func_multi : Function;

		public function InitMainWin() {
		}

		public function init() : void {
			initView();
			initEvent();
		}

		public function dispose() : void {
			_btn_single.dispatcher.removeEventListener(BaseButtonEvent.UP, singleHandler);
			_btn_multi.dispatcher.removeEventListener(BaseButtonEvent.UP, multiHandler);
			_btn_home.dispatcher.removeEventListener(BaseButtonEvent.UP, homeHandler);
			DisplayObjUtils.removeAllChildren(this);
			_btn_home = _btn_multi = _btn_single = null;
			_func_home = _func_multi = _func_single = null;
			graphics.clear();
		}

		private function initEvent() : void {
			_btn_single.dispatcher.addEventListener(BaseButtonEvent.UP, singleHandler);
			_btn_multi.dispatcher.addEventListener(BaseButtonEvent.UP, multiHandler);
			_btn_home.dispatcher.addEventListener(BaseButtonEvent.UP, homeHandler);
		}

		public function set func_single(func : Function) : void {
			_func_single = func;
		}

		public function set func_home(func : Function) : void {
			_func_home = func;
		}

		public function set func_multi(func : Function) : void {
			_func_multi = func;
		}

		private function homeHandler(event : Event) : void {
			_func_home();
		}

		private function singleHandler(event : Event) : void {
			_func_single();
		}

		private function multiHandler(event : Event) : void {
			_func_multi();
		}

		private function initView() : void {

		}
	}
}