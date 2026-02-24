insert into users (id, name, email, password_hash, role, created_at)
values (
           gen_random_uuid(),
           'Admin',
           'admin@local.com',
           '$2a$10$KqVT7K2AKMtQl7dSz5udWuql.OAORtFjmRNi9/RnqgVkeU4ViTal2',
           'ADMIN',
           now()
       );