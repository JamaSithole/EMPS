package co.za.ngwane.epms.repository
{
	import mx.collections.ArrayCollection;

	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Outputtbl")]
	public class Outputtbl
	{
		private var _id : Number;
		private var _name : String;
		private var _budspend : Number;
		private var _totbud : Number;
		private var _q1 : Number;
		private var _q2 : Number;
		private var _q3 : Number;
		private var _q4 : Number;
		private var _outcometblid : Outcometbl;
		private var _q1a : Number;
		private var _q2a : Number;
		private var _q3a : Number;
		private var _q4a : Number;
		private var  _refno : String;
		private var _userid : Userepms;
		private var _q1fs : String;
		private var _q2fs : String;
		private var _q3fs : String;
		private var _q4fs : String;
		private var _currq : String;
		private var _stat : String;
		private var _avgScore: Number;
		private var _description : String; 
		private var _indicator : String;
		private var _quantitative : Boolean;
		private var _updates : ArrayCollection;
		private var _outputComplete  : Boolean;
		
		public function get userid():Userepms
		{
			return _userid;
		}

		public function set userid(value:Userepms):void
		{
			_userid = value;
		}

		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get budspend():Number
		{
			return _budspend;
		}

		public function set budspend(value:Number):void
		{
			_budspend = value;
		}

		public function get totbud():Number
		{
			return _totbud;
		}

		public function set totbud(value:Number):void
		{
			_totbud = value;
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

		public function get outcometblid():Outcometbl
		{
			return _outcometblid;
		}

		public function set outcometblid(value:Outcometbl):void
		{
			_outcometblid = value;
		}

		public function get q4a():Number
		{
			return _q4a;
		}

		public function set q4a(value:Number):void
		{
			_q4a = value;
		}

		public function get q3a():Number
		{
			return _q3a;
		}

		public function set q3a(value:Number):void
		{
			_q3a = value;
		}

		public function get q2a():Number
		{
			return _q2a;
		}

		public function set q2a(value:Number):void
		{
			_q2a = value;
		}

		public function get q1a():Number
		{
			return _q1a;
		}

		public function set q1a(value:Number):void
		{
			_q1a = value;
		}

		public function get refno():String
		{
			return _refno;
		}

		public function set refno(value:String):void
		{
			_refno = value;
		}

		public function get q1fs():String
		{
			return _q1fs;
		}

		public function set q1fs(value:String):void
		{
			_q1fs = value;
		}

		public function get q2fs():String
		{
			return _q2fs;
		}

		public function set q2fs(value:String):void
		{
			_q2fs = value;
		}

		public function get q3fs():String
		{
			return _q3fs;
		}

		public function set q3fs(value:String):void
		{
			_q3fs = value;
		}

		public function get q4fs():String
		{
			return _q4fs;
		}

		public function set q4fs(value:String):void
		{
			_q4fs = value;
		}

		public function get name():String
		{
			return _name;
		}

		public function set name(value:String):void
		{
			_name = value;
		}

		public function get currq():String
		{
			return _currq;
		}

		public function set currq(value:String):void
		{
			_currq = value;
		}

		public function get stat():String
		{
			return _stat;
		}

		public function set stat(value:String):void
		{
			_stat = value;
		}

		public function get updates():ArrayCollection
		{
			return _updates;
		}

		public function set updates(value:ArrayCollection):void
		{
			_updates = value;
		}

		public function get avgScore():Number
		{
			return _avgScore;
		}

		public function set avgScore(value:Number):void
		{
			_avgScore = value;
		}

		public function get description():String
		{
			return _description;
		}

		public function set description(value:String):void
		{
			_description = value;
		}

		public function get indicator():String
		{
			return _indicator;
		}

		public function set indicator(value:String):void
		{
			_indicator = value;
		}

		public function get quantitative():Boolean
		{
			return _quantitative;
		}

		public function set quantitative(value:Boolean):void
		{
			_quantitative = value;
		}

		public function get outputComplete():Boolean
		{
			return _outputComplete;
		}

		public function set outputComplete(value:Boolean):void
		{
			_outputComplete = value;
		}


	}
}