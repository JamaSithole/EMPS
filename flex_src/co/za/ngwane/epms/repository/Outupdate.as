package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Outupdate")]
	public class Outupdate
	{
		private var _id : Number;
		private var _q1 : Number;
		private var _q2 : Number;
		private var _q3 : Number;
		private var _q4 : Number;
		private var _outputtblid : Outputtbl;

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get q1():Number
		{
			return _q1;
		}

		public function set q1(value:Number):void
		{
			_q1 = value;
		}

		public function get q2():Number
		{
			return _q2;
		}

		public function set q2(value:Number):void
		{
			_q2 = value;
		}

		public function get q3():Number
		{
			return _q3;
		}

		public function set q3(value:Number):void
		{
			_q3 = value;
		}

		public function get q4():Number
		{
			return _q4;
		}

		public function set q4(value:Number):void
		{
			_q4 = value;
		}

		public function get outputtblid():Outputtbl
		{
			return _outputtblid;
		}

		public function set outputtblid(value:Outputtbl):void
		{
			_outputtblid = value;
		}


	}
}