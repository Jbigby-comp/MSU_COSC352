let () =
  Printf.printf "Enter your name: ";
  let name = read_line () in
  Printf.printf "Enter a number: ";
  let times = try int_of_string (read_line ()) with
    | _ -> (Printf.eprintf "Error: <number> must be an integer.\n"; exit 1) in
  for _ = 1 to times do
    Printf.printf "Hello %s\n" name
  done

