import { Role } from "./role.enum";

export class User {
  id: number | undefined;
  username: string = "";
  password: string = "";
  confirmPassword: string = "";
  firstName: string =  "";
  lastName: string = "";
  token: string = "";
  role: Role = Role.USER;
  success: boolean = false;
}
