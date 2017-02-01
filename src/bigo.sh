#!/usr/bin/env bash
#biggy script

#statics
mgxcmd="../../asterixdb/managix/bin/managix"
AQLcmd="python3 AdapterAsterix/QueryInstance.py"
#function run
run(){
	read -e -p "biggy>>> " cmd
	history -s "$cmd"
	while [ "$cmd" != "quit" ]
	do
		history -s "$cmd"
		#pre-process cmd
		cmdarr=($cmd)
		#run biggy
		case "${cmdarr[0]}" in
			#input
			"input")
			echo "input..."
			;;
			#store
			"store")
			echo "store..."
			case "${cmdarr[1]}" in
				"-new")
				cmd="create dataverse ""${cmdarr[2]}"";"
				$AQLcmd "$cmd"
				;;
				"-delete")
				cmd="drop dataverse ""${cmdarr[2]}"";"
				$AQLcmd "$cmd"
				;;
				*)
				echo "Paras Missing!"
				;;
			esac			
			echo "stored."
			;;
			#compute
			"compute")
			echo "compute..."
			case "${cmdarr[1]}" in
				"-query")
				#cmd="use dataverse bigdb; for \$ds in dataset Metadata.Dataset return \$ds"
				cmd="${cmdarr[@]:2}"
				$AQLcmd "$cmd"
				;;
				"-analysis")
				cmd="${cmdarr[@]:2}"
				$AQLcmd "$cmd"
				;;
				*)
				echo "Paras Missing!"
				;;
			esac			
			echo "computed."
			;;
			#control
			"control")
			echo "control..."
			;;
			#output
			"output")
			echo "output..."
			;;
			#commond error
			*)
			echo "Command Error!"
			;;	
		esac	
		#pass cmd to internal
		#newcmd="describe -n mydb"
		#$mgxcmd "$newcmd"
		read -e -p "biggy>>> " cmd
	done
}

if [ "$1" == "install" ]
then 
	#install projects
	echo "installing biggy..."
	echo "installed biggy."
elif [ "$2" != "biggy" ]
then
	echo "Command Error!"
elif [ "$3" == "" ]
then 
	echo "Command Error!"
else
	#manage biggy
	case "$1" in
		#new
		"new")
		echo "newing biggy ""$3""..."
		newcmd="create -n ""$3"" -c ../../asterixdb/managix/clusters/local/local.xml"
		$mgxcmd "$newcmd"
		echo "new biggy ""$3"" end."
		;;
		#start
		"start")
		echo "starting biggy ""$3""..."
		newcmd="start -n ""$3"
		$mgxcmd "$newcmd"
		echo "start biggy ""$3"" end."
		#run
		;;
		#use
		"use")
		echo "using biggy ""$3""..."
		run
		echo "use biggy ""$3"" end."
		;;
		#stop
		"stop")
		echo "stopping biggy ""$3""..."
		newcmd="stop -n ""$3"
		$mgxcmd "$newcmd"
		echo "stop biggy ""$3"" end."
		;;
		#delete
		"delete")
		echo "deleting biggy ""$3""..."
		newcmd="delete -n ""$3"
		$mgxcmd "$newcmd"
		echo "delete biggy ""$3"" end."
		;;
		#info
		"info")
		echo "infoing biggy ""$3""..."
		newcmd="describe -n ""$3"
		$mgxcmd "$newcmd"
		echo "info biggy ""$3"" end."
		;;
		#commond error
		*)
		echo "Command Error!"
		;;	
	esac
fi
