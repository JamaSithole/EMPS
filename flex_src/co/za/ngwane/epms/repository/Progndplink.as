package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Progndplink")]
	public class Progndplink
	{
		public function Progndplink()
		{
		}
		
		private var _id : Number;
		private var _progid : Progtbl;
		private var _ndpid : Ndp;
		
		private var _ndpName : String;
		private var _progName : String;
		
		public function get ndpName():String
		{
			return _ndpName;
		}
		
		public function set ndpName(value:String):void
		{
			_ndpName = value;
		}
		
		public function get progName():String
		{
			return _progName;
		}
		
		public function set progName(value:String):void
		{
			_progName = value;
		}

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get progid():Progtbl
		{
			return _progid;
		}

		public function set progid(value:Progtbl):void
		{
			_progid = value;
		}

		public function get ndpid():Ndp
		{
			return _ndpid;
		}

		public function set ndpid(value:Ndp):void
		{
			_ndpid = value;
		}

	}
}