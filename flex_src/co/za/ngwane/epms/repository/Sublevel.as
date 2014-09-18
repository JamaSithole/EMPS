package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Sublevel")]
	public class Sublevel
	{
		private var _id : Number;
		private var _name : String;
		private var _description : String;
		private var _levelid : Leveltbl;

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get name():String
		{
			return _name;
		}

		public function set name(value:String):void
		{
			_name = value;
		}

		public function get description():String
		{
			return _description;
		}

		public function set description(value:String):void
		{
			_description = value;
		}

		public function get levelid():Leveltbl
		{
			return _levelid;
		}

		public function set levelid(value:Leveltbl):void
		{
			_levelid = value;
		}


	}
}