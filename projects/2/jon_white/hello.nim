import os, strutils

proc main() =
  if paramCount() < 1:
    echo "Usage: ./hello <name> [number]"
    return

  let name = paramStr(1)
  let count = if paramCount() > 1: parseInt(paramStr(2)) else: 1

  for i in 1..count:
    echo i, ": Hello ", name

main()
