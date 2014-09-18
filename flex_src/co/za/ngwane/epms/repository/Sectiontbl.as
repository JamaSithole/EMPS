package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Sectiontbl")]
	public class Sectiontbl
	{
		private var _id : Number;
		private var _name : String;
		private var _description : String;
		private var _directorateid : Directorate;


		public function get directorateid():Directorate
		{
			return _directorateid;
		}

		public function set directorateid(value:Directorate):void
		{
			_directorateid = value;
		}

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

	}
}