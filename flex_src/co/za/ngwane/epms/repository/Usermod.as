package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Usermod")]
	public class Usermod
	{
		public function Usermod()
		{
		}
		
		private var _id : Number;
		private var _module : Sysmod;
		private var _user : Userepms;

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get module():Sysmod
		{
			return _module;
		}

		public function set module(value:Sysmod):void
		{
			_module = value;
		}

		public function get user():Userepms
		{
			return _user;
		}

		public function set user(value:Userepms):void
		{
			_user = value;
		}


	}
}