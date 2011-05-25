/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.play.ui.layer {
	import flash.display.Sprite;
	import flash.utils.Dictionary;

	/**
	 * @author XuTiancheng
	 * 2011-5-23下午10:24:55
	 */
	public class LayerManager {
		private var _dty_layer : Dictionary;
		private var _spt_main : Sprite;

		public function LayerManager() {
			super();
		}

		public function init() : void {
			_dty_layer = new Dictionary();
			_spt_main = new Sprite();
			_dty_layer[LayerConst.background] = new Sprite();
			_dty_layer[LayerConst.bottom] = new Sprite();
			_dty_layer[LayerConst.middle] = new Sprite();
			_dty_layer[LayerConst.top] = new Sprite();
			_spt_main.addChild(_dty_layer[LayerConst.background]);
			_spt_main.addChild(_dty_layer[LayerConst.bottom]);
			_spt_main.addChild(_dty_layer[LayerConst.middle]);
			_spt_main.addChild(_dty_layer[LayerConst.top]);
		}

		public function getLayer(flag : int = 1) : Sprite {
			switch (flag) {
				case -1:
					return _dty_layer[LayerConst.background];
				case 0:
					return _dty_layer[LayerConst.bottom];
				case 1:
					return _dty_layer[LayerConst.middle];
				case 2:
					return _dty_layer[LayerConst.top];
				default:
					trace("Bad switch in LayerManager.getLayer() flag =>" + flag);
					return null;
			}
		}

		public function get mainSpt() : Sprite {
			return _spt_main;
		}
	}
}