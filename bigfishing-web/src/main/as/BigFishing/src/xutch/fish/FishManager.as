/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.fish {

	/**
	 * @author XuTiancheng
	 * 2011-5-22下午03:57:43
	 */
	public class FishManager implements IFishManager {
		private var _fishProduction : FishProduction;

		public function FishManager() {
		}

		public function init() : void {
			_fishProduction = new FishProduction();
		}

		public function get fishP() : IFishProduction {
			return _fishProduction;
		}
	}
}