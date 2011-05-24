/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch {
	import xutch.data.DataManager;
	import xutch.data.IDataManager;
	import xutch.fish.IFishManager;
	import xutch.play.ui.IUIManager;

	/**
	 * @author XuTiancheng
	 * 2011-5-22下午03:54:04
	 */
	public class Xutch {
		private static var _ins : Xutch;
		private var _fishM : IFishManager;
		private var _dataM : IDataManager;
		private var _uiM : IUIManager;

		public function Xutch() {
			if (_ins != null)
				throw new Error("only one Xutch");
			_ins = this;
			_dataM = new DataManager();
		}

		public static function get ins() : Xutch {
			if (_ins == null)
				new Xutch();
			return _ins;
		}

		public function get dataM() : IDataManager {
			return _dataM;
		}

		public function get uiM() : IUIManager {
			return _uiM;
		}

		public function get fishM() : IFishManager {
			return _fishM;
		}
	}
}