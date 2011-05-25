/**
 * MSN/E-mail:lost_player@163.com
 */
package xutch.xutchClass {
	import flash.events.Event;

	/**
	 * @author XuTiancheng
	 * 2011-3-1
	 * 队列事件
	 */
	public class QueueEvent extends Event {
		public static const FULL : String = "full";
		public static const IN : String = "in";
		public static const OUT : String = "out";
		public static const EMPTY : String = "empty";
		private var _child : QueueChild;

		public function QueueEvent(type : String, bubbles : Boolean = false, cancelable : Boolean = false) {
			super(type, bubbles, cancelable);
		}


		public function get child() : QueueChild {
			return _child;
		}

		public function set child(value : QueueChild) : void {
			_child = value;
		}

	}
}