num_processes=10
 
for ((i=1; i<=num_processes; i++))
do
    # Forking a child process
       (sleep 60) &
           echo "Created process with PID: $!"
           done
