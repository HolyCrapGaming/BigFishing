/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.fish {
	import flash.display.MovieClip;

	/**
	 * @author XuTiancheng
	 * 2011-5-22上午11:32:06
	 * 鱼素材的基类
	 *
	 * normal
	 * hit
	 * die
	 */
	public class BaseFishAsset extends MovieClip {
		public function BaseFishAsset() {
			super();
		}

		public function normal() : void {
			gotoAndPlay("normal");
		}

		public function hit() : void {
			gotoAndPlay("hit");
		}

		public function die() : void {
			gotoAndPlay("die");
		}
	}
}