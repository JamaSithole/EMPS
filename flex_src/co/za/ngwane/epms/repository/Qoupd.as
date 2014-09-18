package co.za.ngwane.epms.repository
{
	[Binable][RemoteClass(alias="co.za.ngwane.epms.repository.Qoupd")]
	public class Qoupd
	{
		private var _id : Number;
		
		private var _quo : String;
		private var _qscore : Number;
		private var _comment : String;
		private var _paction : String; 	// planned action
		private var _pastartd : Date; 	// plan action start date
		private var _paendd : Date; 	// plan action end date
		private var _auditstatus : String;
		private var _outputtblid : Outputtbl;
		private var _stat : Number;
		private var _tmet : Boolean;
		private var _reasonf : String;
		private var _coraction : String;
		private var _createD : Date;
		private var _statUpdateD : Date;
		private var _currentqTarget : String;
		private var _budspend :  Number;
		private var _statusDescription : String;
		
		//this are just additional fields that I am using in poe, dont worry too much about them
		private var _target : Number;
		private var _targetClient : String;
		private var _actual : Number;
		private var _actualClient : String;
		private var _budspendClient : String;
		
		//the below are fields that I think they need to be introduced
		
		public function get id():Number
		{
			return _id;
		}

		public function set id(value:Number):void
		{
			_id = value;
		}

		public function get quo():String
		{
			return _quo;
		}

		public function set quo(value:String):void
		{
			_quo = value;
		}

		public function get comment():String
		{
			return _comment;
		}

		public function set comment(value:String):void
		{
			_comment = value;
		}

		public function get paction():String
		{
			return _paction;
		}

		public function set paction(value:String):void
		{
			_paction = value;
		}

		public function get pastartd():Date
		{
			return _pastartd;
		}

		public function set pastartd(value:Date):void
		{
			_pastartd = value;
		}

		public function get paendd():Date
		{
			return _paendd;
		}

		public function set paendd(value:Date):void
		{
			_paendd = value;
		}

		public function get auditstatus():String
		{
			return _auditstatus;
		}

		public function set auditstatus(value:String):void
		{
			_auditstatus = value;
		}

		public function get outputtblid():Outputtbl
		{
			return _outputtblid;
		}

		public function set outputtblid(value:Outputtbl):void
		{
			_outputtblid = value;
		}

		public function get stat():Number
		{
			return _stat;
		}

		public function set stat(value:Number):void
		{
			_stat = value;
		}

		public function get tmet():Boolean
		{
			return _tmet;
		}

		public function set tmet(value:Boolean):void
		{
			_tmet = value;
		}

		public function get reasonf():String
		{
			return _reasonf;
		}

		public function set reasonf(value:String):void
		{
			_reasonf = value;
		}

		public function get coraction():String
		{
			return _coraction;
		}

		public function set coraction(value:String):void
		{
			_coraction = value;
		}

		public function get qscore():Number
		{
			return _qscore;
		}

		public function set qscore(value:Number):void
		{
			_qscore = value;
		}

		public function get createD():Date
		{
			return _createD;
		}

		public function set createD(value:Date):void
		{
			_createD = value;
		}

		public function get statUpdateD():Date
		{
			return _statUpdateD;
		}

		public function set statUpdateD(value:Date):void
		{
			_statUpdateD = value;
		}

		public function get currentqTarget():String
		{
			return _currentqTarget;
		}

		public function set currentqTarget(value:String):void
		{
			_currentqTarget = value;
		}

		public function get budspend():Number
		{
			return _budspend;
		}

		public function set budspend(value:Number):void
		{
			_budspend = value;
		}

		public function get statusDescription():String
		{
			return _statusDescription;
		}

		public function set statusDescription(value:String):void
		{
			_statusDescription = value;
		}

		public function get target():Number
		{
			return _target;
		}

		public function set target(value:Number):void
		{
			_target = value;
		}

		public function get targetClient():String
		{
			return _targetClient;
		}

		public function set targetClient(value:String):void
		{
			_targetClient = value;
		}

		public function get actual():Number
		{
			return _actual;
		}

		public function set actual(value:Number):void
		{
			_actual = value;
		}

		public function get actualClient():String
		{
			return _actualClient;
		}

		public function set actualClient(value:String):void
		{
			_actualClient = value;
		}

		public function get budspendClient():String
		{
			return _budspendClient;
		}

		public function set budspendClient(value:String):void
		{
			_budspendClient = value;
		}


	}
}