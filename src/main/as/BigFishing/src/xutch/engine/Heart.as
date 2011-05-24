/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.engine {
	import flash.display.Sprite;
	import flash.events.Event;
	import flash.utils.Dictionary;

	/**
	 * @author XuTiancheng
	 * 2011-5-22下午12:01:30
	 */
	public class Heart {
		private var _vct_funcs : Vector.<Function>;
		private var _spt_tag : Sprite = new Sprite();
		private var _dty_funcs : Dictionary = new Dictionary(true);

		public function Heart() {
		}

		/**
		 * 会干掉相同的
		 */
		public function add(func : Function, obj : *) : void {
			for (var i : int = 0, lenI : int = _vct_funcs.length; i < lenI; i++)
				if (_vct_funcs[i] == func && _dty_funcs[func] === obj)
					return;
			_vct_funcs.push(func);
			_dty_funcs[func] = obj;
		}

		public function del() : void {

		}

		public function stop() : void {
			_spt_tag.removeEventListener(Event.ENTER_FRAME, frameHandler);
		}

		public function play() : void {
			_spt_tag.addEventListener(Event.ENTER_FRAME, frameHandler);
		}

		public function reset() : void {
			_vct_funcs.length = 0;
		}

		private function frameHandler(event : Event) : void {
			for (var i : int = 0, lenI : int = _vct_funcs.length; i < lenI; i++) {

			}
		}
	}
}