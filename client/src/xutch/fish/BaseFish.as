/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.fish {
	import flash.display.MovieClip;
	import flash.display.Sprite;

	/**
	 * @author XuTiancheng
	 * 2011-5-22上午11:27:59
	 * 鱼
	 */
	public class BaseFish {
		public var asset : BaseFishAsset;
		private var _num_accelX : Number;
		private var _num_accelY : Number;
		private var _num_speedX : Number;
		private var _num_speedY : Number;

		public function BaseFish() {
			super();
		}

		/**
		 * 处理速度
		 */
		public function processSpeed() : void {
			_num_speedX += _num_accelX;
			_num_speedY += _num_accelY;
		}

		/**
		 * 移动
		 */
		public function move() : void {
			asset.x += _num_speedX;
			asset.y += _num_speedY;
		}
	}
}