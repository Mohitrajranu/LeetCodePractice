# LeetCodePractice
#HadoopPractice
/**************Hadoop In Real World**************/
Hadoop In Real World *** http://www.hadoopinrealworld.com
Facebook Mutual Friends
/**************Hadoop In Real World**************/

--Upload input to HDFS
hadoop fs -mkdir input/facebook
hadoop fs -copyFromLocal /hirw-workshop/input/facebook/* input/facebook

--Delete output directory
hadoop fs -rm -r output/facebook

--Execute MapReduce job
hadoop jar /hirw-workshop/mapreduce/facebook/FacebookFriends-0.0.1.jar com.hirw.facebookfriends.mr.FacebookFriendsDriver  -libjars /hirw-workshop/mapreduce/facebook/json-simple-1.1.jar /user/hirw/input/facebook output/facebook

--Review output
hadoop fs -ls output/facebook
hadoop fs -libjars /hirw-workshop/mapreduce/facebook/FacebookFriends-0.0.1.jar -text output/facebook/part-r-00000

/**************Hadoop In Real World**************/
Hadoop In Real World *** http://www.hadoopinrealworld.com
NY Times - Time Machine (inspired)
/**************Hadoop In Real World**************/

hadoop fs -mkdir input/text-to-pdf
hadoop fs -rm -r input/text-to-pdf/*
hadoop fs -copyFromLocal /hirw-workshop/input/text-to-pdf/* input/text-to-pdf

Delete Output Directory: 
hadoop fs -rm -r output/text-to-pdf

Submit Job: 
hadoop jar /hirw-workshop/mapreduce/text-to-pdf/text-to-pdf-1.0.jar com.hirw.convertor.mr.TextToPdf -libjars /hirw-workshop/mapreduce/text-to-pdf/lib/itext-2.1.7.jar /user/hirw/input/text-to-pdf output/text-to-pdf

hadoop fs -ls output/text-to-pdf

rm output/text-to-pdf/*
hadoop fs -copyToLocal output/text-to-pdf/* output/text-to-pdf
