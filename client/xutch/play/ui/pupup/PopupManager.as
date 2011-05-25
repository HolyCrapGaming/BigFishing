/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.play.ui.pupup {
	import flash.display.DisplayObject;
	import flash.display.Sprite;

	import xutch.xutchClass.Queue;
	import xutch.xutchClass.QueueChild;

	/**
	 * @author XuTiancheng
	 * 2011-5-25下午04:01:02
	 * 弹出框的管理
	 */
	public class PopupManager implements IPopupManager{
		private var _queue : Queue;
		private var _spt_top : Sprite;

		public function PopupManager() {
		}

		public function init(sp : Sprite) : void {
			_queue = new Queue();
			_spt_top = sp;
		}

		public function addPopup(win : DisplayObject) : void {
			_spt_top.addChild(win);
		}

		public function addPopupInQueue(win : DisplayObject, priority : int = 1) : void {
			var child : QueueChild = new QueueChild(win, priority);
			_queue.addChild(child);
			next();
		}

		public function removePopup(win : DisplayObject) : void {
			if (_spt_top === win.parent)
				_spt_top.removeChild(win);
			next();
		}

		private function next() : void {
			var child : QueueChild = _queue.next();
			if (child != null)
				addPopup(child.target);
		}
	}
}